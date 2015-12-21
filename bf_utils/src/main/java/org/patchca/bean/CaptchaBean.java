package org.patchca.bean;

import java.util.Date;

/**
 * 验证码类
 */
public class CaptchaBean {
    //文本值
    private String txt;
    //创建时间
    private Date createTime;
    //来源ip
    private String fromIp;
    //有效时间
    private long effectiveTime;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }


    /**
     * 验证码是否过期
     *
     * @return
     */
    public boolean isEffective() {
        Date nowDate = new Date();
        Date createDate = this.getCreateTime();
        return (createDate.getTime() + this.getEffectiveTime()) > nowDate.getTime();
    }


}
