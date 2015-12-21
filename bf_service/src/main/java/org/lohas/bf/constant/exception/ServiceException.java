package org.lohas.bf.constant.exception;

import org.lohas.bf.pojo.MessageErrorCode;

/**
 * Created with IntelliJ IDEA.
 * User: fule
 * Date: 13-6-8
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 * 用户处理业务错误的异常
 */
public class ServiceException extends RuntimeException {
    private String msg;
    private Object errorData;
    private static final long serialVersionUID = 1L;

    private MessageErrorCode errorCode; // 错误枚举

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
        msg = message;
    }

    public MessageErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(MessageErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 枚举 错误
     * @param errorCode
     */
    public ServiceException(MessageErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorData = errorCode.getReasonPhrase();
        this.msg = errorCode.getValue();
    }

    public ServiceException(Object errorData,String message) {
        this.msg = message;
        this.errorData = errorData;
    }

    public String getMessage() {
        return msg == null || "".equals(msg) ? "系统服务异常"
                : msg;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }


}
