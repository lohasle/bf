import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.lohas.bf.utils.ThreadPollExecutor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lohas on 2015/6/19.
 * https://github.com/lohasle
 * <p>
 * <p>
 * v2 版本测试工具
 */
public class RestApiTestTools {


    // 构造 要加密的参数
    public static String Par(Map<String, String> map) {
        String result = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result += (entry.getKey()) + "=" + entry.getValue() + "&";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }


    /**
     * post 请求测试
     */
    public static void PostTest(String url, Map<String, String> params) throws IOException {

        String timestamp = params.get("timestamp");
        String userId = params.get("userId");
        String token = params.get("token");
        String sign = params.get("sign");


        //构建请求参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();

        // 遍历参数
        System.out.println("地址：" + url);
        System.out.println("\n参数：");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry);
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        // 测试
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8);
        httppost.setEntity(entity);
        CloseableHttpResponse response = client.execute(httppost);
        String state = String.valueOf(response.getStatusLine().getStatusCode());
        String jsonStr = EntityUtils.toString(response.getEntity());

        System.out.println("\n-----------响应结果----------");
        System.out.println("state---->" + state);
        System.out.println("response:---->\n" + jsonStr);
    }


    /**
     * post 请求测试
     */
    public static void GetTest(String url, Map<String, String> params) throws IOException {

        String timestamp = params.get("timestamp");
        String userId = params.get("userId");
        String token = params.get("token");
        String sign = params.get("sign");


        String parStr = "";
        // 遍历参数
        int index = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (index == 0) {
                parStr += entry.getKey() + "=" + entry.getValue();
            } else {
                parStr += "&" + entry.getKey() + "=" + entry.getValue();
            }
            index++;
        }

        // 拼接 待？的地址
        String[] urls = url.split("\\?");
        if (urls.length > 1) {
            url = urls[0];
            for (int i = 1; i < urls.length; i++) {
                String[] _par = urls[i].split("&");
                for (String s : _par) {
                    parStr += "&" + s;
                }
            }
        }

        System.out.println("userId:" + userId);
        System.out.println("token:" + token);
        System.out.println("sign:" + sign);
        System.out.println("-----------地址-----\n" + url + "?" + parStr);
        System.out.println("-------------------------");

        // 测试
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url + "?" + parStr);


        CloseableHttpResponse response = client.execute(httpGet);
        String state = String.valueOf(response.getStatusLine().getStatusCode());
        String jsonStr = EntityUtils.toString(response.getEntity());

        System.out.println("state---->"+state);
        System.out.println("response:---->\n"+jsonStr);
    }
}
