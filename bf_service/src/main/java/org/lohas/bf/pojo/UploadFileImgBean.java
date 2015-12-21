package org.lohas.bf.pojo;

/**
 * Created by lohas on 2015/3/14.
 * 图片文件  上传类
 */
public class UploadFileImgBean {


    private String model;   //存储的文件模块路径

    private Long fileMaxSize; // 文件最大大小


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(Long fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    private ImgScaleBean imgScaleBean;

    public ImgScaleBean getImgScaleBean() {
        return imgScaleBean;
    }

    public void setImgScaleBean(Integer width, Integer height) {
        imgScaleBean = new ImgScaleBean(width, height);
    }


    public void setImgScaleBean(Double scalaSize) {
        imgScaleBean = new ImgScaleBean(scalaSize);
    }

    public class ImgScaleBean {
        private Integer width;
        private Integer height;
        private Double scalaSize;

        public ImgScaleBean() {
        }


        public ImgScaleBean(Integer width, Integer height) {
            this.width = width;
            this.height = height;
        }

        public ImgScaleBean(Double scalaSize) {
            this.scalaSize = scalaSize;
        }


        public Integer getWidth() {
            return width;
        }

        public ImgScaleBean setWidth(Integer width) {
            this.width = width;
            return this;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Double getScalaSize() {
            return scalaSize;
        }

        public void setScalaSize(Double scalaSize) {
            this.scalaSize = scalaSize;
        }


        /**
         * 默认小图名字
         */
        public static final String DEFAULT_MIN_NAME = "_min";


    }
}
