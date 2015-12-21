package org.lohas.bf.pojo;

import java.io.Serializable;

/**
 * 业务 消息实体
 *
 */

public class Message<T> implements Serializable {

    public Message() {
    }


    public Message(String success) {
        this.success = success;
    }

    public Message(String success, T data) {
        this.success = success;
        if(data instanceof MessageErrorCode){
            // 错误类型
            MessageErrorCode data1 = (MessageErrorCode) data;
            this.data = (T) data1.getReasonPhrase();
            this.errorCode = data1.getValue();
        }else{
            this.data = data;
        }
    }

    public Message(String success, T data, String errorCode) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "success='" + success + '\'' +
                ", data=" + data +
                ", token='" + token + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    /**
     * 处理成功
     */
    public static final String STATE_TRUE = "true";

    /**
     * 处理失败
     */
    public static final String STATE_FALSE = "false";


    private String success;   //成功状态
    private T data;           // 数据体
    private String token;     // token
    private String errorCode; //  错误代码

}
