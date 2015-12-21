package org.lohas.bf.utils.img.task;

import org.lohas.bf.utils.img.ImageUtils;

import java.io.File;
import java.util.Arrays;

/**
 * Created by lohas on 2015/5/7.
 * https://github.com/lohasle
 * 压缩服务处理类
 * * *****.jpg?thumbnail/300x300    启动压缩服务得到300x300的图片
 * *****.jpg?thumbnail/!0.6    启动压缩服务得到原图0.6倍压缩的图片
 * *****.jpg?rotate/90    启动旋转服务得到原图顺时针旋转90的图片
 * *****.jpg?thumbnail/300x300-rotate/90    得到原图300x300并且旋转90度之后的照片
 * ......
 */

public class ImgTaskThumbnail implements ImgTask {

    /**
     * 参数描述
     */
    private String params;

    /**
     * 倍数
     */
    private Double scale;

    /**
     * 宽度
     */
    private int width;

    /**
     * 高度
     */
    private int height;

    private String imgSrc;


    public ImgTaskThumbnail(String params, String imgSrc) {
        this.params = params;
        this.imgSrc = imgSrc;
        if (params.indexOf("x") > -1) {
            String[] strs = params.split("x");
            this.width = Integer.parseInt(strs[0]);
            this.height = Integer.parseInt(strs[1]);
        } else if (params.indexOf("!") > -1) {
            this.scale = Double.parseDouble(params.substring(params.indexOf("!")+1, params.length()));
        }
    }

    @Override
    public String execute() {
        String desPath = null;
        if (scale == null) {
            //改为宽高
            desPath = ImageUtils.buildParamPath(imgSrc,"_"+width+"_"+height);
            if(!new File(desPath).exists()){
                ImageUtils.scale(imgSrc, desPath, width, height);
            }
        } else {
            //缩小
            desPath = ImageUtils.buildParamPath(imgSrc,"_"+scale);
            if(!new File(desPath).exists()) {
                ImageUtils.scale(imgSrc, desPath, scale);
            }

        }
        return desPath;
    }

    public static void main(String[] args) {
        String str = "800x800";
        String[] strings = str.split("x");
        System.out.println(strings.length + "\t" + Arrays.toString(strings));
    }

}
