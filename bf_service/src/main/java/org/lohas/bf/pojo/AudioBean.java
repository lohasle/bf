package org.lohas.bf.pojo;

/**
 * Created by lohas on 2015/4/9.
 * 音频对象 语音消息
 */
public class AudioBean {
    /**
     * 音频路径
     */
    private String path;
    /**
     * 音频长度
     */
    private long length;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public AudioBean() {
    }

    public AudioBean(String path, long length) {
        this.path = path;
        this.length = length;
    }
}
