package org.lohas.bf.utils.img;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by lohas on 2015/2/11.
 */
public class ImageUtils {
    private static Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    /**
     * 默认小图名字
     */
    public static final String DEFAULT_MIN_NAME = "_min";


    /**
     * 按照指定大小缩放(不按照比例)
     *
     * @param srcPath
     * @param desPath
     * @return
     */
    public static void scaleNoRatio(String srcPath, String desPath, int width, int height) {
        //scale(比例)
        try {
            //keepAspectRatio(false) 默认是按照比例缩放的
            Thumbnails.of(srcPath)
                    .size(width, height)
                    .keepAspectRatio(false)
                    .toFile(desPath);
            logger.info(srcPath + " 缩略图-->" + desPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照指定大小缩放 按照比例
     *
     * @param srcPath
     * @param desPath
     * @return
     */
    public static void scale(String srcPath, String desPath, int width, int height) {
        //scale(比例)
        try {
            //keepAspectRatio(false) 默认是按照比例缩放的
            Thumbnails.of(srcPath)
                    .size(width, height)
                    .keepAspectRatio(true)
                    .toFile(desPath);
            logger.info(srcPath + " 缩略图-->" + desPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 按照比例进行缩放
     *
     * @param srcPath
     * @param desPath
     * @return
     */
    public static void scale(String srcPath, String desPath, double scalaSize) {
        //scale(比例)
        try {
            Thumbnails.of(srcPath)
                    .scale(scalaSize)
                    .toFile(desPath);
            logger.info(srcPath + " 缩略图-->" + desPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照比例进行缩放
     *
     * @param srcPath
     * @return
     */
    public static BufferedImage scale(String srcPath, double scalaSize) {
        //scale(比例)
        try {
            BufferedImage bufferedImage = Thumbnails.of(srcPath)
                    .scale(scalaSize)
                    .asBufferedImage();
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 按照指定大小缩放(不按照比例)
     *
     * @param srcPath
     * @return
     */
    public static BufferedImage scaleNoRatio(String srcPath, int width, int height) {
        try {

            BufferedImage bufferedImage = Thumbnails.of(srcPath)
                    .size(width, height)
                    .keepAspectRatio(false)
                    .asBufferedImage();
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按照指定大小缩放 按照比例
     *
     * @param srcPath
     * @return
     */
    public static BufferedImage scale(String srcPath, int width, int height) {
        try {
            BufferedImage bufferedImage = Thumbnails.of(srcPath)
                    .size(width, height)
                    .keepAspectRatio(true)
                    .asBufferedImage();
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 判断是否是图片
     *
     * @param filePath
     * @return
     */
    public static boolean isImage(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            return false;
        }
        String ext = filePath.substring(filePath.lastIndexOf(".") + 1);
        return "jpg".equalsIgnoreCase(ext)
                || "png".equalsIgnoreCase(ext)
                || "bmp".equalsIgnoreCase(ext)
                || "jpeg".equalsIgnoreCase(ext)
                || "gif".equalsIgnoreCase(ext);
    }

    /**
     * 根据 原图  拿到小图地址
     *
     * @param srcPath
     * @return
     */
    public static String buildMinPath(String srcPath) {
        if (isImage(srcPath)) {
            int point = srcPath.lastIndexOf(".");
            String str1 = srcPath.substring(0, point); // aa
            String str2 = srcPath.substring(point);// .jpg
            return str1 + DEFAULT_MIN_NAME + str2;
        }
        return null;
    }

    /**
     * 改变图片地址  在其结尾加上参数
     *
     * @param srcPath
     * @return
     */
    public static String buildParamPath(String srcPath,String suffix) {
        if (isImage(srcPath)) {

            //1
            String path = srcPath.substring(0,srcPath.lastIndexOf("/"));

            //2
            String filePath = srcPath.substring(srcPath.lastIndexOf("/"),srcPath.length());

            int point = filePath.lastIndexOf(".");
            String str1 = filePath.substring(0, point); // aa
            String str2 = filePath.substring(point);// .jpg
            return path+str1+suffix+str2;
        }
        return null;
    }
}
