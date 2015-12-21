package org.lohas.bf.web.view;

/**
 * Created by lohas on 2015/7/16.
 * https://github.com/lohasle
 * view 层 model 对象
 */
public class InputTempMobel {
    /**
     * 标题
     */
    private String title;
    /**
     * 返回地址
     */
    private String backUrl;
    /**
     * 成功后的跳转地址
     */
    private String successUrl;
    /**
     * 表单提交地址
     */
    private String actionUrl;
    /**
     * 按钮文字
     */
    private String btnTxt;


    /**
     * input 表单名称
     */
    private String inputName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getBtnTxt() {
        return btnTxt;
    }

    public void setBtnTxt(String btnTxt) {
        this.btnTxt = btnTxt;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }
}
