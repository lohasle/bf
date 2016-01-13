package org.lohas.bf.services.impl;

import org.apache.commons.lang.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.security.HttpSessionKey;
import org.lohas.bf.services.CommonService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.lohas.bf.spring.WebUtils;
import org.lohas.bf.utils.ThreadPollExecutor;
import org.lohas.bf.utils.file.FileUtils;
import org.lohas.bf.utils.img.ImageUtils;
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
