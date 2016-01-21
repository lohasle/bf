package org.lohas.bf.utils.qq;

public class User extends com.belerweb.social.qq.connect.bean.User {
  private String openid;//用户QQ号码转化得到的ID（当pf=qplus时返回）。

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }
}
