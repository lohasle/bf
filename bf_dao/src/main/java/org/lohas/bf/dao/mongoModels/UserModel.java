package org.lohas.bf.dao.mongomodels;

import org.lohas.bf.utils.MD5Utils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fule https:github.com/lohasle on 2016/1/14 0014.
 * 用户模型
 */
@Document(collection = "users")
public class UserModel {

    /**
     * 登录需要返回的字段
     */
    public static final String FIELDS_LOGIN = "{userName:1,phone:1,avatar:1,ucToken:1,gtCid:1,region:1,pwdHash:1,salt:1}";


    /**
     * 详情信息
     */
    public static final String FIELDS_INFO = "{userName:1,phone:1,avatar:1,ucToken:1,gtCid:1,region:1,sex:1,birthDate:1,avatar:1}";

    /**
     * mongo _id
     */
    @Id
    private String id;

    /**
     * 用户自增序列
     */
    private Integer seq;

    private String name;

    private String userName;

    private String pwdHash;

    private String sex;

    private String phone;

    private Date birthDate;

    private String avatar;

    private String email;

    private String address;

    private String idcard;

    private String qqOpenId;

    private String weiboOpenId;

    private String wechatOpenId;

    private BigDecimal lng;

    private BigDecimal lat;

    private String salt;

    private Integer state;

    private Date createTime;

    private Date modifyTime;

    private String ucToken;

    private String gtCid;

    private String version;

    private RegionModel region;


   



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getWeiboOpenId() {
        return weiboOpenId;
    }

    public void setWeiboOpenId(String weiboOpenId) {
        this.weiboOpenId = weiboOpenId;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }


    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUcToken() {
        return ucToken;
    }

    public void setUcToken(String ucToken) {
        this.ucToken = ucToken;
    }

    public String getGtCid() {
        return gtCid;
    }

    public void setGtCid(String gtCid) {
        this.gtCid = gtCid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


    public boolean validatePwd(String pwd) {
        String salt = this.getSalt();
        String pwdHash = this.getPwdHash();
        String encode = MD5Utils.encode(pwd, salt);
        return encode.equals(pwdHash);
    }

    public UserModel simple() {
        this.setSalt(null);
        this.setPwdHash(null);
        return this;
    }

}

