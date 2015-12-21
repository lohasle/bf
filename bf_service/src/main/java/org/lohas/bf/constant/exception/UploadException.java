package org.lohas.bf.constant.exception;

/**
 * Created by lohas on 2015/3/16.
 * 上传文件异常
 */
public class UploadException extends Exception {
    private String msg;
    private Object errorData;
    private static final long serialVersionUID = 1L;

    public UploadException() {
        super();
    }

    public UploadException(String message) {
        super(message);
        msg = message;
    }

    public UploadException(Object errorData, String message) {
        this.msg = message;
        this.errorData = errorData;
    }

    public String getMessage() {
        return msg == null || "".equals(msg) ? "上传异常"
                : msg;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

}
