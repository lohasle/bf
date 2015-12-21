package org.lohas.bf.pojo;

import java.io.Serializable;

/**
 * Created by lohas on 2015/6/23.
 * https://github.com/lohasle
 * 错误码规定
 */
public enum MessageErrorCode implements Serializable {
    SYS_NEED_UPDATE("999", "亲,请升级版本"),
    SYS_INNER_ERROR("1000", "服务错误"),
    SYS_ILLEGAL_ERROR("1001", "请求被篡改"),
    SYS_EXPIRED_ERROR("1002", "过期的请求"),
    SYS_PARAM_ERROR("1003", "请求参数异常，请检查参数"),
    SYS_TOKEN_ERROR("1004", "token 无效"),
    SYS_PAR_ERROR("1005", "参数验证未通过"),
    SYS_AUTH_ERROR("1010", "无权限操作"),
    SYS_NOT_LOGIN("1011", "尚未登录，请登录"),
    SYS_LOGIN_FAIL_ERROR("1012", "登录失败，请重试"),
    SYS_SERVICE_PARAM_ERROR("1013", "服务异常，请检查参数"),
    SYS_SERVICE_ERROR("1014", "服务异常"),
    SYS_REQUEST_METHOD_ERROR("1015", "不被支持的请求类型"),
    SYS_LOGIN_ERROR("1111", "电话号码或者密码错误"),
    SYS_REG_PHONE_ERROR("1112", "请输入电话号码"),
    SYS_REG_PHONE_VALIDATE_ERROR("1113", "请先通过手机验证"),
    SYS_SMS_SEND_ERROR("1114", "短信发送失败"),



    SCHEDULE_INVALID_ERROR("2001", "当前日程无效"),
    SCHEDULE_EXPIRE_ERROR("2002", "当前日程已过期"),
    SCHEDULE_USED_ERROR("2003", "当前日程已被安排"),
    SCHEDULE_LOCKED_ERROR("2004", "当前日程已有用户预约"),
    SCHEDULE_TIME_ERROR("2005", "此时间段，您已经预约了其他医生"),
    SCHEDULE_NOT_FIND_ERROR("2006", "找不到指定日程"),


    SCHEDULE_STATE_NOT_FIND_ERROR("3001", "日程使用了不存在的状态"),
    SCHEDULE_STATE_COMPLETE_ERROR("3002", "日程不能手动修改为完成状态"),


    SERVICE_NOT_FIND_ERROR("4001","找不到指定服务(商品)"),
    DOCTOR_PHONE_NOT_FIND_ERROR("4101","医生电话为空，无法咨询"),
    DOCTOR_NOT_VERIFY_ERROR("4102", "医生未通过审核，请审核后重试"),
    UCPASS_ERROR("4201","电话咨询失败"),

    INQUIRY_REPLYED_ERROR("4301","您已经回答过此问题,可以到我的回答查看"),
    INQUIRY_ACCEPT_STATE_YES_ERROR("4302","回答已经采纳，不能修改"),
    INQUIRY_DOCTOR_NOE_ENABLE_ERROR("4303","医生未通过审核，不能回答"),


    ORDER_NOT_FIND_ERROR("5001", "找不到该订单"),
    ORDER_NOT_PAY_ERROR("5002", "订单未支付"),
    ORDER_USED_ERROR("5003", "订单已被使用"),
    ORDER_CHANEL_ERROR("5004", "非确认状态和待支付状态不能取消"),
    ORDER_EVALUATE_ERROR("5005", "订单已经点评过了"),
    PAY_REPEAT_ERROR("5101", "重复支付"),
    PAY_REFUND_REPEAT_ERROR("5102", "重复退款"),
    PAY_DO_ERROR("5201", "发起支付失败"),
    PAY_REFUND_ERROR("5202", "退款失败"),
    PAY_PING_ERROR("5301", "支付服务错误"),
    PAY_PING_VERIFY_ERROR("5302", "支付验证失败"),
    ;


    private final String value;

    private final String reasonPhrase;

    private MessageErrorCode(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public String getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
