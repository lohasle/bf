package org.lohas.bf.constant;

import org.lohas.bf.dao.common.SYS_GLOBAL;

import java.math.BigDecimal;

/**
 * 常量类，常量统一放在这里统一管理
 */
public class Constant {

    /**
     * 显示(正常)状态
     */
    public static final Integer STATE_ENABLE = 1;

    /**
     * 隐藏（时效）状态
     */
    public static final Integer STATE_DISABLE = 0;


    /**
     * 审核失败的状态
     */
    public static final Integer STATE_CHECK_FALSE = 2;

    /**
     * 日 *
     */
    public static final String DAY = "day";
    /**
     * 周 *
     */
    public static final String WEEK = "week";
    /**
     * 月 *
     */
    public static final String MONTH = "month";
    /**
     * 年 *
     */
    public static final String YEAR = "year";

    /**
     * 季
     */
    public static final String QUARTER = "quarter";

    /**
     * 邮箱后缀
     */
    public static final String EMAIL_SUFFIX = "@weizy.cn";

    /**
     * token 过期时间
     * 默认1个小时  一个月
     */
    public static final long TOKEN_EFFECTIVE_TIME = 60 * 1000 * 60 * 24 * 7;


    /**
     * 默认距离五公里之内
     */
    public static final BigDecimal DISTANCE_DEFAULT = BigDecimal.valueOf(1000);


    /**
     * 评论默认评分
     */
    public static final int EVALUATE_DEFAULT_SCORE = 80;


    /**
     * 系统Id 系统配置类型
     */
    public static final String CONFIG_TYPE_USER_SYS_ID = "pz_sys_user_id";


    /**
     * 排序  倒序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 排序  顺序
     */
    public static final String ORDER_ASC = "asc";


    /**
     * 环信用户前缀（普通用户）
     */
    public static final String HX_USER_PREFIX = "uu_";


    /**
     * 上传文件基本路径
     */
    public static final String UPLOAD_ROOT = "upload/";


    /**
     * qa语音类型
     */
    public static final String UPLOAD_QA_AUDIO = "upload/audio/qa/";


    /**
     * msg语音类型
     */
    public static final String UPLOAD_MSG_AUDIO = "upload/audio/msg/";


    /**
     * 普通图片上传路径
     */
    public static final String UPLOAD_MODEL_IMG = UPLOAD_ROOT + "images/";

    /**
     * qa 问答图片上传路径
     */
    public static final String UPLOAD_MODEL_IMG_QA = UPLOAD_ROOT + "images/qa/";


    /**
     * msg图片上传路径
     */
    public static final String UPLOAD_MODEL_IMG_MSG = UPLOAD_ROOT + "images/msg/";


    /**
     * 头像上传路径
     */
    public static final String UPLOAD_MODEL_IMG_HEAD = UPLOAD_ROOT + "images/head/";


    /**
     * 默认经度   深圳
     */
    public static final BigDecimal DEFAULT_LNG = BigDecimal.valueOf(113.950723);

    /**
     * 默认维度
     */
    public static final BigDecimal DEFAULT_LAT = BigDecimal.valueOf(22.558888);



    /**
     * 验证码session 有效时间  10分钟
     */
    public static final long CAPTCHA_EFFECTIVE_TIME = 60 * 1000 * 10;

    /**
     * 一天之内ip请求次数
     */
    public static final int IP_REGISTER_COUNT_LIMIT = 5;


    /**
     * 用户类型 普通用户
     */
    public static final String USER_TYPE_USER = "1";

    /**
     * 用户类型 医生
     */
    public static final String USER_TYPE_DOCTOR = "2";


    /**
     * 内容格式  文字
     */
    public static final Integer CONTENT_TYPE_TXT = 1;

    /**
     * 内容格式  图片
     */
    public static final Integer CONTENT_TYPE_IMG = 2;


    /**
     * 内容格式  语音
     */
    public static final Integer CONTENT_TYPE_AUDIO = 3;


    /**
     * 默认缩放级别  0.5
     */
    public static final Double SCALA_SIZE_DEFAULT = 0.5;


    /**
     * 发送  开
     */
    public static final String SEND_ENABLE = "1";

    /**
     * 发送  关
     */
    public static final String SEND_DISABLE = "0";


    /**
     * 验证码长度
     */
    public static final Integer CAPTCHA_LENGTH = 4;


    /**
     * 回调地址key
     */
    public static final String  CALL_URL_BACK_KEY = "cburl";



    /**
     * 医小二的用户id
     */
    public static final Integer SNSUSER_DEFAULT_CUSTOMER = 1;



    /**
     * uc_key
     */
    public static final String UC_KEY = SYS_GLOBAL.getConfig("dz.ucKey");

    /**
     * uc_token_key
     */
    public static final String UC_TOKEN_KEY = SYS_GLOBAL.getConfig("dz.ucTokenKey");

    /**
     * 会话类型  咨询
     */
    public static final String HX_SESSION_TYPE_QA = "1";


    /**
     * 会话类型  私信
     */
    public static final String HX_SESSION_TYPE_MSG = "2";


    /**
     * 会话类型  回帖提醒
     */
    public static final String HX_SESSION_TYPE_THREAD_REPLY = "2";


    /**
     * 空参数
     */
    public static final Object NULL_PAR = null;


    /**
     * 短信有效期时长 2 分钟
     */
    public static final int SMS_EFFECT_TIME_LONG = 2;


    /**
     * app token 请求参数名称
     */
    public static final String APP_TOKEN_PARAM_KEY = "token";

    /**
     * app userId 请求参数名称
     */
    public static final String APP_USERID_PARAM_KEY = "userId";

    /**
     * token 生成地址
     */
    public static final String GENERATE_TOKEN_URL = "/app/getToken";


}
