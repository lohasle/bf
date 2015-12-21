package org.lohas.bf.web.controller;

import org.lohas.bf.utils.img.task.ImgTaskQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by lohas on 2015/5/7.
 * https://github.com/lohasle
 * 图片处理接口
 * 目前处理压缩大小
 * *****.jpg?thumbnail/300x300    启动压缩服务得到300x300的图片
 * *****.jpg?thumbnail/!0.6    启动压缩服务得到原图0.6倍压缩的图片
 * *****.jpg?rotate/90    启动旋转服务得到原图顺时针旋转90的图片
 * *****.jpg?thumbnail/300x300-rotate/90    得到原图300x300并且旋转90度之后的照片
 * ......
 */
//@Controller
//@RequestMapping(value ={"/upload/img","/upload/images"})
public class ImgController {

    private Logger logger = LoggerFactory.getLogger(ImgController.class);


//    @RequestMapping({"*.png", "*.jpg", "/**/*.png", "/**/*.jpg"})
    public void getImgBySize(HttpServletRequest request,
                             HttpServletResponse response) {
        String basePath = request.getServletContext().getRealPath("/");// 项目绝对跟路径
        String imgUrl = request.getRequestURI(); //图片地址
        imgUrl = imgUrl.substring(imgUrl.indexOf("upload"), imgUrl.length());

        String ytImgStr = basePath + imgUrl; // 原图路径
        File imgFile = null;


        Enumeration<String> enumeration = request.getParameterNames();//参数


        //参数检测
        if (enumeration.hasMoreElements()) {
            String param = enumeration.nextElement();

            //解析参数
            ImgTaskQueue imgTaskQueue  = new ImgTaskQueue(ytImgStr,param);

            List<String> list =  imgTaskQueue.executeQueue();

            imgFile = new File(list.get(0)); //目前仅仅是压缩

        } else {
            imgFile = new File(ytImgStr);
        }


        //输出图片
        if (imgFile != null) {
            response.setContentType("image/png,image/jpeg");
//            response.setHeader("Cache-Control", "no-cache, no-store");
//            response.setHeader("Pragma", "no-cache");
            final long time = System.currentTimeMillis();
            response.setDateHeader("Last-Modified", time);
            response.setDateHeader("Date", time);
            response.setDateHeader("Expires", time);

            FileInputStream fis = null;
            try {
                if(imgFile.exists()){
                    OutputStream out = response.getOutputStream();
                    fis = new FileInputStream(imgFile);
                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    out.write(b);
                    out.flush();
                    response.flushBuffer();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                logger.debug("图片服务出错");
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }

        }

    }
}
