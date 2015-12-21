package org.lohas.bf.utils.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.lohas.bf.utils.ThreadPollExecutor;
import org.lohas.bf.utils.file.FileUtils;
import org.lohas.bf.utils.img.ImageUtils;
import org.lohas.bf.utils.wx.bean.WxAccessToken;
import org.lohas.bf.utils.wx.bean.WxCacheInfo;
import org.lohas.bf.utils.wx.bean.WxUserInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lohas on 2015/4/14.
 * https://github.com/lohasle
 * 微信开放平台工具类
 */
public class WxOpenUtils {
    private static Logger logger = LoggerFactory.getLogger(WxOpenUtils.class);


    public static final String SNSAPI_BASE = "snsapi_base";
    public static final String SNSAPI_USERINFO = "snsapi_userinfo";

    public static Map<String, WxCacheInfo> wxCacheMap = new ConcurrentHashMap<>();  // 缓存信息  缓存各个微信公众号的 token 等凭据


    /**
     * 得到 获得code 的动态地址
     *
     * @param appId appid
     * @param state
     * @param scope snsapi_base 基本授权 snsapi_userinfo
     * @return
     */
    public static String getAuthCodeUrl(String redirectUri, String appId, String state, String scope) throws UnsupportedEncodingException {
        String redirect_uri = URLEncoder.encode(redirectUri, "utf-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=" + scope + "&state=" + state + "#wechat_redirect";
        return url;
    }

    /**
     * 取得 登录使用的 oAuthAccessToken   此token 需实时获取
     * 第三方登陆
     * 关于网页授权access_token和普通access_token的区别
     * <p/>
     * 1、微信网页授权是通过OAuth2.0机制实现的，在用户授权给公众号后，公众号可以获取到一个网页授权特有的接口调用凭证（网页授权access_token），通过网页授权access_token可以进行授权后接口调用，如获取用户基本信息；
     * 2、其他微信接口，需要通过基础支持中的“获取access_token”接口来获取到的普通access_token调用。
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return
     * @throws IOException
     */
    public static WxAccessToken getOAuthAccessToken(String appId, String appSecret, String code) throws IOException {
        //通过code换取网页授权access_token
        HttpUriRequest uriRequest_wx_access_token = new HttpGet(URI.create("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + appSecret + "&code=" + code + "&grant_type=authorization_code"));

        HttpResponse response = getClient(true).execute(uriRequest_wx_access_token);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String tokenJsonStr = EntityUtils.toString(response.getEntity());
            logger.debug("wx-token---->" + tokenJsonStr);
            JSONObject tokenJsonObj = JSON.parseObject(tokenJsonStr);
            return JSON.toJavaObject(tokenJsonObj, WxAccessToken.class);
        } else {
            return null;
        }
    }


    /**
     * 通过openId  拿到微信用户数据
     *
     * @param oAuthAccessToken 登录授权的oAuthAccessToken
     * @param openId
     * @return
     * @throws IOException
     */
    public static WxUserInfo getUserInfo(String oAuthAccessToken, String openId) throws IOException {
        // 2 通过openId  拿到微信用户数据
        HttpUriRequest uriRequest_wx_user = new HttpGet("https://api.weixin.qq.com/sns/userinfo?access_token=" + oAuthAccessToken + "&openid=" + openId + "&lang=zh_CN");
        HttpResponse response_wx_user = getClient(true).execute(uriRequest_wx_user);
        if (response_wx_user.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String wxUserJsonStr = EntityUtils.toString(response_wx_user.getEntity());
            wxUserJsonStr = new String(wxUserJsonStr.getBytes("iso-8859-1"), "utf-8");
            logger.debug("--wx-userinfo->" + wxUserJsonStr);
            JSONObject wxUserJsonObj = JSON.parseObject(wxUserJsonStr);
            //取得了用户信息
            return JSON.toJavaObject(wxUserJsonObj, WxUserInfo.class);
        } else {
            //授权失败
            return null;
        }
    }


    /**
     * 检验oAuthAccessToken
     *
     * @return
     * @throws IOException
     */
    public static boolean validateOAuthAccessToken(String oAuthAccessToken, String openId) throws IOException {
        // 2 通过openId  拿到微信用户数据
        HttpUriRequest uriRequest_wx_user = new HttpGet("https://api.weixin.qq.com/sns/auth?access_token=" + oAuthAccessToken + "&openid=" + openId);
        HttpResponse response_wx_user = getClient(true).execute(uriRequest_wx_user);
        if (response_wx_user.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response_wx_user.getEntity());
            logger.debug("--validateOAuthAccessToken->" + jsonStr);
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            return jsonObject.getInteger("errcode") == 0; // 0  true
        } else {
            //授权失败
            return false;
        }
    }

    /**
     * Create a httpClient instance
     *
     * @param isSSL
     * @return HttpClient instance
     */
    private static HttpClient getClient(boolean isSSL) {

        HttpClient httpClient = new DefaultHttpClient();
        if (isSSL) {
            X509TrustManager xtm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            try {
                SSLContext ctx = SSLContext.getInstance("TLS");

                ctx.init(null, new TrustManager[]{xtm}, null);

                SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

                httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));

            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        return httpClient;
    }


    /**
     * 取得微信 accessToken
     * 1 当前缓存无token 或者 token过期 会取一次
     * 2 取得token 成功  会记录到缓存中
     * 3 第一次取失败，会尝试第二次获取
     * 4 如果当前缓存有token 并且没有过期 直接返回token
     *
     * @return
     */
    public static synchronized String getAccessToken(String appId, String appSecret) {
        WxCacheInfo cacheInfo = wxCacheMap.get(appId);// 得到缓存的公众号信息
        if (cacheInfo != null && StringUtils.isNotBlank(cacheInfo.getAccessToken())) {
            // 已经有了 token 检测是否已经过期
            Date createDate = cacheInfo.getCreateTime();
            createDate = DateUtils.addMinutes(createDate, WxCacheInfo.expires_in);
            if (createDate.before(new Date())) {
                // 过期了  重新 获取
                logger.info("获取wx-accessToken过期了，尝试重新获取");
                return _getAccessToken2(appId, appSecret);
            } else {
                //没有过期
                logger.info("load cache token");
                return cacheInfo.getAccessToken();
            }
        } else {
            // 当前无 token
            return _getAccessToken2(appId, appSecret);
        }
    }


    /**
     * 取得微信 jsapiTicket
     *
     * @return
     */
    public static synchronized String getJsapiTicket(String appId, String appSecret) {
        WxCacheInfo cacheInfo = wxCacheMap.get(appId);// 得到缓存的公众号信息
        if (cacheInfo != null && StringUtils.isNotBlank(cacheInfo.getJsapiTicket())) {
            // 已经存在 JsapiTicket
            logger.info("load cache JsapiTicket");
            return cacheInfo.getJsapiTicket();
        } else {
            // 当前无 JsapiTicket
            String accessToken = getAccessToken(appId, appSecret);
            try {
                HttpUriRequest rep = new HttpGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi");
                HttpResponse response = getClient(true).execute(rep);

                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    String jsonStr = EntityUtils.toString(response.getEntity());
                    logger.debug("--获取JsapiTicket->" + jsonStr);
                    JSONObject jsonObject = JSON.parseObject(jsonStr);
                    String ticket = jsonObject.getString("ticket");
                    cacheInfo.setJsapiTicket(ticket);
                    return cacheInfo.getJsapiTicket();
                } else {
                    logger.error("--获取JsapiTicket失败->" + EntityUtils.toString(response.getEntity()));

                    logger.info("--尝试第二次获取JsapiTicket");
                    HttpResponse response2 = getClient(true).execute(rep);
                    if (response2.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        String jsonStr = EntityUtils.toString(response2.getEntity());
                        logger.debug("--获取JsapiTicket2->" + jsonStr);
                        JSONObject jsonObject = JSON.parseObject(jsonStr);
                        String ticket = jsonObject.getString("ticket");
                        cacheInfo.setJsapiTicket(ticket);
                        return cacheInfo.getJsapiTicket();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("wx js ticket 获取失败");
            }
            return "";
        }
    }

    /**
     * 下载微信多媒体文件
     *
     * @param path1 项目据对地址的前半部分
     * @param path2 文件存储的文件夹相对位置
     * @return path2+返回的文件名
     */
    public static String downLoadImgFile(String token, String mediaId, String path1, String path2) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + token + "&media_id=" + mediaId);
        HttpResponse response = null;
        String rootPath = path1 + "/" + path2;
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String fileName = System.currentTimeMillis() + ".jpg";
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                InputStream inputStream = response.getEntity().getContent();
                //保存文件
                FileUtils.saveInputStreamToFile(inputStream, rootPath + "/" + fileName);
                //压缩
                ImageUtils.scale(rootPath + "/" + fileName, rootPath + "/" + fileName, 0.6);
                return path2 + "/" + fileName;
            } else {
                String jsonStr = EntityUtils.toString(response.getEntity());
                logger.error("下载文件失败-->" + jsonStr);
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("下载文件失败");
        }
        return "";
    }

    /**
     * 下载微信多媒体文件
     *
     * @param path1 项目据对地址的前半部分
     * @param path2 文件存储的文件夹相对位置
     * @return path2+返回的文件名
     */
    public static String downLoadImgFileAsy(final String token, final String mediaId, final String path1, final String path2) {
        Future<String> future =  ThreadPollExecutor.exeThread(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String srt = downLoadImgFile(token, mediaId, path1, path2);
                return srt;
            }
        });
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String _getAccessToken(String appId, String appSecret) {
        try {
            HttpUriRequest rep = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
            HttpResponse response = getClient(true).execute(rep);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String jsonStr = EntityUtils.toString(response.getEntity());
                logger.debug("--获取wx-accessToken->" + jsonStr);
                JSONObject jsonObject = JSON.parseObject(jsonStr);
                return jsonObject.getString("access_token");
            } else {
                logger.error("获取wx-accessToken失败" + EntityUtils.toString(response.getEntity()));
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("获取wx-accessToken失败");
        }
        return "";

    }

    private static String _getAccessToken2(String appId, String appSecret) {
        WxCacheInfo cacheInfo = wxCacheMap.get(appId);// 得到缓存的公众号信息
        cacheInfo = cacheInfo == null ? new WxCacheInfo() : cacheInfo;
        // 同步拿到最新的 token
        String token = _getAccessToken(appId, appSecret);
        if (StringUtils.isNotBlank(token)) {
            // 取得token  进行更新
            cacheInfo.setAccessToken(token);
        } else {
            // 在进行一次获取
            logger.info("获取wx-accessToken获取失败，尝试第二次获取");
            cacheInfo.setAccessToken(_getAccessToken(appId, appSecret));
        }
        cacheInfo.setCreateTime(new Date());
        wxCacheMap.put(appId, cacheInfo);
        return cacheInfo.getAccessToken();
    }

    /**
     * js sdk 签名算法
     *
     * @param jsapi_ticket
     * @param url
     * @return
     */
    public static Map<String, String> jsSdkSign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
