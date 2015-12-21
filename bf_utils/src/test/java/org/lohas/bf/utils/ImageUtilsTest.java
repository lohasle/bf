package org.lohas.bf.utils;

import org.lohas.bf.utils.img.ImageUtils;
import org.junit.Test;

import java.awt.image.BufferedImage;

public class ImageUtilsTest {

    @Test
    public void testScale() throws Exception {

    }

    @Test
    public void testScale1() throws Exception {
        String str = "D:\\workspace\\weizy_server\\serverWeb\\target\\weizy_server\\upload\\img\\head\\1421658966362.jpg";
        String str1 = "D:\\workspace\\weizy_server\\serverWeb\\target\\weizy_server\\upload\\img\\head\\1421371053737_min.jpg";
        BufferedImage bufferedImage =  ImageUtils.scale(str, 1);

    }



    @Test
    public void testImgRep() throws Exception {
        String str = "增么不行？<br />\r\n<img src=\"http://www.sinaimg.cn/dy/slidenews/4_img/2015_12/704_1579361_641420.jpg\" border=\"0\" alt=\"\" />" +
                "<img src=\\\"static/image/smiley/default/huffy.gif\\\" smilieid=\\\"5\\\" border=\\\"0\\\" alt=\\\"\\\" /><br/>\r\n这样行吗？"
                + "你好我来啦<br />\r\n<img width=\"150\" height=\"150\" src=\"http://119.29.64.12/upload/images/20150410/1428660399411.jpg\" border=\"0\" alt=\"\" />";




        System.out.println(str.indexOf("<img")>-1);

        str = str.replaceAll("(?i)(<img.+src=\"?.+)(static\\/image\\/smiley\\/default)(.+gif?.+\\>)","$1http://119.29.19.92/$2$3");
        //加路径

        //加属性
        String regex = "(?i)(\\<img)([^\\>]+\\>)";
        str = str.replaceAll (regex, "$1 style=\"max-width=100%;height:auto\"$2");

        System.out.println(str);

    }



}