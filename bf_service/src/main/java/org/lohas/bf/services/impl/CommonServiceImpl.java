package org.lohas.bf.services.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.MessageErrorCode;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.security.HttpSessionKey;
import org.lohas.bf.services.CommonService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.lohas.bf.spring.WebUtils;
import org.lohas.bf.utils.StringUtil;
import org.lohas.bf.utils.ThreadPollExecutor;
import org.lohas.bf.utils.file.FileUtils;
import org.lohas.bf.utils.img.ImageUtils;
import org.lohas.bf.utils.ucenterapi.Client;
import org.lohas.bf.utils.ucenterapi.UcUserInfo;
import org.lohas.bf.utils.ucenterapi.XMLHelper;
import org.lohas.bf.utils.ucenterapi.dz.UcAuthCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lohas on 2015/3/13.
 */
@Service
@Transactional
public class CommonServiceImpl extends BasicServiceImpl implements CommonService {
    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);


    @Override
    public Client getUcClient() {
        return uClient;
    }

    @Override
    public Map ucSynRegister(String ucUserName, String pwd) {
        return uc_syn_register(ucUserName, pwd);
    }

    /**
     * 同步注册ucenter
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Boolean ucSynRegister2(String userName, String password) {
        Map ucMap = ucSynRegister(userName, password);

        Integer ucresult = (Integer) ucMap.get("code");
        if (ucresult < 0 || ucresult == null) {
            //注册失败
            logger.debug("ucenter--->" + userName + "注册失败");
        } else {
            //注册uc成功 登录下
            String result = uClient.uc_user_login(userName, password);
            LinkedList<String> rs = XMLHelper.uc_unserialize(result);
            if (rs.size() > 0 && Integer.parseInt(rs.get(0)) > 0) {
                //注册成功
                logger.info("ucenter---->用户名:" + userName + "  密码:" + password + "  注册成功");
                return true;
            }
        }
        return false;
    }


    /**
     * 更改ucenter 名称
     *
     * @return -1 登录失败
     */
    public String ucSynChangeName(String newUserName,String ucToken) {
        String[] nameAndPwd = UcAuthCode.getNameAndPwd(ucToken, Constant.UC_TOKEN_KEY);
        String ucUserName = nameAndPwd[0];
        String pwd = nameAndPwd[1];
        if(ucUserName.equals(newUserName)){
            return "1";
        }
        try {
            //登录ucenter 取得uc用户信息
            UcUserInfo ucUserInfo = UcUserInfo.getUcUserInfo(uClient.uc_user_login(ucUserName, pwd));
            if (ucUserInfo.getUid() > 0) {
                //登录成功
                String result = uClient.uc_user_synrename(String.valueOf(ucUserInfo.getUid()), ucUserName, newUserName);
                if (!"1".equals(result)) {
                    logger.debug("uc--->" + newUserName + "用户名已存在");
                    throw new ServiceException("用户名" + newUserName + "已存在");
                }
                logger.info("uc-discuz modify userName-->" + ucUserName + "--->" + newUserName);
                return result;
            } else {
                //登录失败
                throw new ServiceException("社区登录失败，无权限");
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }

    /**
     * uc设置新的密码
     *
     * @param newPwd
     * @param ucToken
     * @return
     */
    @Override
    public String ucUserSynRepwd(String newPwd, String ucToken) {
        String[] nameAndPwd = UcAuthCode.getNameAndPwd(ucToken, Constant.UC_TOKEN_KEY);
        String ucUserName = nameAndPwd[0];
        String pwd = nameAndPwd[1];
        return uClient.uc_user_synrepwd(ucUserName,pwd,newPwd);
    }


    /**
     * discuz  用户名生成策略
     *
     * @param userName 用户名
     * @param pwd      密码
     * @param type     策略类型   doctor 医生   wxUser 微信  user普通用户
     * @param count    运行次数
     * @return
     */
    @Override
    public String generateAndRegisterUcCode(String userName, String pwd, String type, int count) {
        Client uClient = getUcClient();

        String ucUserName = userName;

        String _userName = userName;
        if ("doctor".equals(type)) {
            //医生
            ucUserName = userName;

            String lastStr = userName.substring(userName.length() - 1, userName.length());
            String countStr = "";
            if (StringUtils.isNumeric(lastStr)) {
                countStr = String.valueOf(Integer.parseInt(lastStr) + 1);
                userName = userName.substring(0, userName.length() - 1);
            } else {
                countStr = "2";
            }
            _userName = userName + countStr; // 准备下一次用户名 医生uc用户名 拼音加上+随机四位
        } else if ("wxUser".equals(type)) {
            // 微信 用户
            ucUserName = userName.indexOf("_wx") <= -1 ? userName + "_wx" : userName; // 微信uc用户名 拼音加上+随机2位

            // 准备下一次的用户名
            _userName = userName.indexOf("_wx") <= -1 ? userName + StringUtil.RandomIntString(2) + "_wx" : userName.substring(0, userName.indexOf("_wx")) + StringUtil.RandomIntString(2) + "_wx";
        } else if ("qqUser".equals(type)) {
            // 微信 用户
            ucUserName = userName.indexOf("_qq") <= -1 ? userName + "_qq" : userName; // qq uc用户名 拼音加上+随机2位

            // 准备下一次的用户名
            _userName = userName.indexOf("_qq") <= -1 ? userName + StringUtil.RandomIntString(2) + "_qq" : userName.substring(0, userName.indexOf("_qq")) + StringUtil.RandomIntString(2) + "_qq";
        } else if ("user".equals(type)) {

            //普通用户
            ucUserName = userName;
            count = 1;
        }
        Map<String, Object> ucMap = new HashMap<>();
        if (count > 1) {
            try {
                ucMap = ucSynRegister(ucUserName, pwd);
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        } else {
            ucMap = ucSynRegister(ucUserName, pwd);
        }

        Integer ucresult = (Integer) ucMap.get("code");
        if (ucresult < 0 || ucresult == null) {
            //注册失败
            --count;
            if (count == 0) {
                return "";
            }
            logger.debug("ucenter--->" + userName + "注册失败,count:" + count);
            return generateAndRegisterUcCode(_userName, pwd, type, count);
        } else {
            //注册uc成功 登录下
            String result = uClient.uc_user_login(ucUserName, pwd);
            LinkedList<String> rs = XMLHelper.uc_unserialize(result);
            if (rs.size() > 0 && Integer.parseInt(rs.get(0)) > 0) {
                //注册成功
                logger.info("ucenter---->用户名:" + ucUserName + "  密码:" + pwd + "  注册成功");
                return ucUserName;
            } else {
                //注册失败
                --count;
                uClient.uc_user_delete(String.valueOf(ucresult));//删除uc用户
                logger.info("ucenter---->用户名不合要求，删除用户--->" + ucUserName);
                if (count == 0) {
                    return "";
                }
                return generateAndRegisterUcCode(_userName, pwd, type, count);
            }
        }
    }

    public String[] uploadImg(HttpServletRequest request, MultipartFile file, UploadFileImgBean uploadFileImgBean) throws IOException, UploadException {

        // check

        String[] resultImgs = new String[2];


        String basePath = request.getServletContext().getRealPath("/");// 项目绝对跟路径
        logger.info("----------:>" + file.getOriginalFilename());
        String[] fileTypeAndName = FileUtils.getFileNameAndExt(file.getOriginalFilename());
//        String fileName = fileTypeAndName[0];
        String fileType = fileTypeAndName[1];

        //检测文件是否是图片
        Pattern p = Pattern.compile("jpg|png|gif|bmp|jpeg");
        Matcher matcher = p.matcher(fileType.toLowerCase());
        if (!matcher.matches()) {
            throw new UploadException("请上传图片类型");
        }

        if (file == null || file.getSize() == 0) {
            throw new UploadException("请上传文件");
        }

        if (uploadFileImgBean.getFileMaxSize() != null && file.getSize() > uploadFileImgBean.getFileMaxSize()) {
            throw new UploadException("图片大小不能超过" + file.getSize() / (1024 * 1024) + "M，请重新上传");
        }
        //check end


        //上传文件
        UploadFileImgBean.ImgScaleBean imgScale = uploadFileImgBean.getImgScaleBean();
        String sourceUUID = String.valueOf(System.currentTimeMillis());//重命名

        //相对路径
        String rePath = (uploadFileImgBean.getModel() == null ? Constant.UPLOAD_MODEL_IMG : uploadFileImgBean.getModel()) + new SimpleDateFormat("yyyyMMdd").format(new Date());// 相对文件父路径
        String fileParent = basePath + rePath;
        File parentFile = new File(fileParent);
        if (!parentFile.exists()) {
            //父文件不存在 创建
            parentFile.mkdirs();
        }

        resultImgs[0] = rePath + "/" + sourceUUID + "." + fileType;
        String sourcePath = basePath + resultImgs[0];// 原文件 地址
        FileUtils.saveByteToFile(file.getBytes(), sourcePath);

        //处理压缩
        ImageUtils.scale(sourcePath, sourcePath, 0.68); //文件自身压缩
        if (imgScale.getScalaSize() != null) {
            //按照比例压缩
            resultImgs[1] = rePath + "/" + sourceUUID + "_min." + fileType;
            String sourceMinPath = basePath + resultImgs[1];// 原文件 地址
            ImageUtils.scale(sourcePath, sourceMinPath, imgScale.getScalaSize());
        } else if (imgScale.getHeight() != null && imgScale.getWidth() != null) {
            //按照宽高压缩
            resultImgs[1] = rePath + "/" + sourceUUID + "_" + imgScale.getWidth() +
                    "_" + imgScale.getHeight() + "." + fileType;
            String sourceMinPath = basePath + resultImgs[1];// 原文件 地址

            ImageUtils.scale(sourcePath, sourceMinPath, imgScale.getScalaSize());
        } else {
            resultImgs[1] = sourcePath; // 没有压缩参数
        }
        logger.info("图片压缩成功:原图地址" + sourcePath + "--->缩略图地址" + resultImgs[1]);
        return resultImgs;

    }

    /**
     * 上传文件
     *
     * @param request
     * @param file
     * @param uploadRootPath 相对upload 的地址
     * @return
     */
    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file, String uploadRootPath) throws IOException {
        String basePath = request.getServletContext().getRealPath("/");// 项目绝对跟路径
        String[] fileTypeAndName = FileUtils.getFileNameAndExt(file.getOriginalFilename());
//        String fileName = fileTypeAndName[0];
        String fileType = fileTypeAndName[1];
        //上传文件
        String sourceUUID = String.valueOf(System.currentTimeMillis());//重命名
        //相对路径
        String rePath = uploadRootPath + new SimpleDateFormat("yyyyMMdd").format(new Date());// 相对文件父路径
        String fileParent = basePath + rePath;
        File parentFile = new File(fileParent);
        if (!parentFile.exists()) {
            //父文件不存在 创建
            parentFile.mkdirs();
        }
        String sourcePath = basePath + rePath + "/" + sourceUUID + "." + fileType;// 原文件 地址
        FileUtils.saveByteToFile(file.getBytes(), sourcePath);
        return rePath + "/" + sourceUUID + "." + fileType;
    }


    /**
     * 下载图片
     * 返回相对项目的跟路径的地址 大小图
     */
    public String[] downloadImg(final String url, String model) throws IOException {
        HttpServletRequest request = WebUtils.getHttpServletRequest();
        final String basePath = request.getServletContext().getRealPath("/");// 项目绝对跟路径


        //相对路径
        String rePath = model + new SimpleDateFormat("yyyyMMdd").format(new Date());// 相对文件父路径

        final String reFilePath = rePath + "/" + String.valueOf(System.currentTimeMillis()) + ".jpg"; //保存文件的相对路径
        final String minImg = ImageUtils.buildMinPath(reFilePath);


        String fileParent = basePath + rePath;
        File parentFile = new File(fileParent);
        if (!parentFile.exists()) {
            //父文件不存在 创建
            parentFile.mkdirs();
        }

        // 异步下载文件
        ThreadPollExecutor.exeThread(new Runnable() {
            @Override
            public void run() {
                HttpClient httpClient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(url);
                HttpResponse response = null;
                try {
                    response = httpClient.execute(httpGet);
                    InputStream inputStream = response.getEntity().getContent();
                    //保存文件
                    FileUtils.saveInputStreamToFile(inputStream, basePath + reFilePath);
                    //压缩
                    ImageUtils.scale(basePath + reFilePath, basePath + reFilePath, 1);
                    ImageUtils.scale(basePath + reFilePath, basePath + minImg, 0.6);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        });

        return new String[]{reFilePath, minImg};
    }

    /**
     * 验证手机验证码
     * 默认两分钟内有效
     *
     * @param phone
     * @param sessionKey
     * @param session
     * @return
     */
    @Override
    public Message vaildatePhoneYZM(String phone, String yzm, HttpSessionKey sessionKey, HttpSession session) {
        if (session.getAttribute(sessionKey.getName()) == null) {
            return new Message(Message.STATE_FALSE, "验证码错误");
        }


        try {
            // 验证是否正确
            Map map = (Map) session.getAttribute(sessionKey.getName());
            String yzm1 = (String) map.get("val");
            String toPhone = (String) map.get("to");
            Date cdate = DateUtils.parseDate((String) map.get("createDate"), new String[]{"yyyyMMddHHmmss"});
            cdate = DateUtils.addMinutes(cdate, 2);

            if (!phone.equals(toPhone)) {
                //不是该手机
                return new Message(Message.STATE_FALSE, "手机号错误");
            }

            if (!yzm1.equals(yzm)) {
                // 验证码不对
                return new Message(Message.STATE_FALSE, "验证码错误");
            }

            if (cdate.before(new Date())) {
                // 过期了
                return new Message(Message.STATE_FALSE, "验证码已过期，请重新获取");
            }

            // 通过
            return new Message(Message.STATE_TRUE, "ok");
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("短信验证失败");
        }

    }
}
