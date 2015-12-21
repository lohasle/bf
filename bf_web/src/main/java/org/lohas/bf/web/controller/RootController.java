package org.lohas.bf.web.controller;

import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.security.HttpSessionKey;
import org.lohas.bf.services.CommonService;
import org.lohas.bf.spring.WebUtils;
import org.lohas.bf.utils.NetworkUtil;
import org.lohas.bf.utils.StringUtil;
import org.patchca.bean.CaptchaBean;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.WordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by lohas on 2015/3/14.
 */
@Controller
@RequestMapping("/")
public class RootController {
    private Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private CommonService commonService;


    @RequestMapping(value = {"", "/index"})
    public String goIndex1() {
//        return "cms/addDoctor";
        return "redirect:/backstage";
    }


    @RequestMapping(value = "/iframe")
    public String iframe(String src, String app, Model model) {
        model.addAttribute("src", src);
        model.addAttribute("app", app);
        return "iframe";
    }

    /**
     * 输出验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        final long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        cs.setWordFactory(new WordFactory() {
            @Override
            public String getNextWord() {
                return StringUtil.RandomString(Constant.CAPTCHA_LENGTH);
            }
        });
        OutputStream outputStream = response.getOutputStream();
        String captcha = EncoderHelper.getChallangeAndWriteImage(cs, "png", outputStream);

        //验证码
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setCreateTime(new Date());
        captchaBean.setEffectiveTime(Constant.CAPTCHA_EFFECTIVE_TIME);
        captchaBean.setFromIp(NetworkUtil.getIpAddress(request));
        captchaBean.setTxt(captcha);

        session.setAttribute(HttpSessionKey.TEMP_GENERAL.getName(), captchaBean);
        outputStream.flush();
    }


    // 微信浏览器  提示页
    @RequestMapping(value = "/notice")
    public String goNotice() {
        return "mobile/notice";
    }

    /**
     * 上传文件
     * 返回上传文件路径（后期可以存放文件资源的id）
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request,
                           @RequestParam(required = false) String model,
                           @RequestParam MultipartFile[] files,
                           HttpServletResponse servletResponse) throws IOException {
        UploadFileImgBean uploadFileImgBean = new UploadFileImgBean();
        uploadFileImgBean.setFileMaxSize(new Long(1024 * 1024 * 5));//文件最大5M
        uploadFileImgBean.setImgScaleBean(0.5);//0.5倍压缩
        if ("head".equalsIgnoreCase(model)) {
            model = Constant.UPLOAD_MODEL_IMG_HEAD;
        } else if ("qa".equalsIgnoreCase(model)) {
            model = Constant.UPLOAD_MODEL_IMG_QA;
        } else if ("msg".equalsIgnoreCase(model)) {
            model = Constant.UPLOAD_MODEL_IMG_MSG;
        } else {
            model = Constant.UPLOAD_MODEL_IMG;
        }
        uploadFileImgBean.setModel(model);//0.5倍压缩
        Message message = new Message(Message.STATE_TRUE, "");
        List fileNameList = new ArrayList<>();
        for (MultipartFile file : files) {
            Map<String, String> uMap = new HashMap<>();
            try {
                String[] strs = commonService.uploadImg(request, file, uploadFileImgBean);
                uMap.put("fp", strs[0]);//原始文件
                uMap.put("fpmin", strs[1]);//原始文件
                fileNameList.add(uMap);
            } catch (UploadException e) {
                logger.error(e.getMessage(), e);
                message = new Message(Message.STATE_FALSE, e.getMessage());
                break;
            }
            message.setData(fileNameList);
        }
        servletResponse.setContentType("text/html; charset=utf-8");
        WebUtils.responseOutWithJson(servletResponse, message);
    }


    /**
     * apk  下载  自动识别  用户端 和医生端 最新apk
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/download")
    public void downloadApk(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String type = request.getParameter("type");
        String basePath = request.getSession().getServletContext().getRealPath("");
        String path = "upload/apk/";

        //apk文件夹
        File parentFile = new File(basePath + "/" + path);

        File[] fileList = parentFile.listFiles();
        String doctorFilePath = "";
        String userFilePath = "";
        for (File file : fileList) {
            String fname = file.getName();
            if (fname.contains("doctor")) {
                //医生端
                doctorFilePath = fname;
                continue;
            } else {
                //用户端
                userFilePath = fname;
                continue;
            }
        }

        if ("doctor".equals(type)) {
            //医生端
            path += doctorFilePath;
        } else {
            //用户端
            path += userFilePath;
        }

        String ua = request.getHeader("user-agent").toLowerCase();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        if (ua.indexOf("micromessenger") > -1) {
            // 微信
            logger.debug("微信");
            request.getRequestDispatcher("notice").forward(request, response);
        } else {
            //下载
            File file = new File(basePath + path);
            String filename = file.getName();
            InputStream fis = new BufferedInputStream(new FileInputStream(basePath + File.separator + path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);
            os.flush();
            os.close();
        }
    }


}
