package org.lohas.bf.web.controller.rest;

import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.api.QQConnect;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.util.Base64;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.dao.common.SYS_GLOBAL;
import org.lohas.bf.dao.mongomodels.UserModel;
import org.lohas.bf.pojo.LoginUserBean;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.services.CommonService;
import org.lohas.bf.services.UserService;
import org.lohas.bf.spring.RequestLimit;
import org.lohas.bf.utils.JwtUtil;
import org.lohas.bf.utils.NetworkUtil;
import org.lohas.bf.utils.qq.User;
import org.lohas.bf.utils.ucenterapi.dz.UcAuthCode;
import org.lohas.bf.utils.wx.WxOpenUtils;
import org.lohas.bf.utils.wx.bean.WxAccessToken;
import org.lohas.bf.utils.wx.bean.WxUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 * restful  use interface
 */
@RestController
@RequestMapping("/rest/user")
public class RestUserController {


    @Autowired
    private UserService userService;


    @Autowired
    private CommonService commonService;

    final String jwtSecret = SYS_GLOBAL.getConfig("jwt.secret");


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(@Valid LoginUserBean loginUserBean, Errors errors, HttpServletRequest request) throws IOException {
        if (loginUserBean == null) {
            return new ResponseEntity(new Message<>(Message.STATE_FALSE, "参数有问题"), HttpStatus.OK);
        } else {

            //用户类型自动识别登录
            String userType = loginUserBean.getUserType();
            userType = Constant.USER_TYPE_DOCTOR.equals(userType) ? Constant.USER_TYPE_DOCTOR : Constant.USER_TYPE_USER;
            loginUserBean.setUserType(userType);
            loginUserBean.setLastLoginIp(NetworkUtil.getIpAddress(request));

            //默认坐标
            if (loginUserBean.getLat() == null || new BigDecimal(0).compareTo(loginUserBean.getLat()) == 0) {
                loginUserBean.setLat(Constant.DEFAULT_LAT);
            }
            if (loginUserBean.getLng() == null || new BigDecimal(0).compareTo(loginUserBean.getLng()) == 0) {
                loginUserBean.setLng(Constant.DEFAULT_LNG);
            }
        }

        if (errors.hasErrors()) {
            //  --> 验证出了问题
            return new ResponseEntity(new Message<>(Message.STATE_FALSE, "参数有问题"), HttpStatus.OK);
        }


        // 处理app微信登陆
        if (LoginUserBean.FROM_WECHAT.equals(loginUserBean.getFrom())) {
            String wxCode = request.getParameter("code"); // wx code 信息
            if (StringUtils.isBlank(wxCode)) {
                return new ResponseEntity(new Message<>(Message.STATE_FALSE, "授权失败，请检查code"), HttpStatus.OK);
            }
            String appid = SYS_GLOBAL.getConfig("wx.open.AppId");
            String appSecret = SYS_GLOBAL.getConfig("wx.open.AppSecret");
            // code 换token
            WxAccessToken wxAccessToken = WxOpenUtils.getOAuthAccessToken(appid, appSecret, wxCode);//开放平台
            // token 拿到用户信息
            WxUserInfo wxUserInfo = WxOpenUtils.getUserInfo(wxAccessToken.getAccess_token(), wxAccessToken.getOpenid());
            loginUserBean.setWxUserInfo(wxUserInfo);
        } else if (LoginUserBean.FROM_QQ.equals(loginUserBean.getFrom())) {

            //处理QQ登录
            String qqCode = request.getParameter("code"); // qq code 信息
            if (StringUtils.isBlank(qqCode)) {
                return new ResponseEntity(new Message<>(Message.STATE_FALSE, "授权失败，请检查code"), HttpStatus.OK);
            }
            String openIdAndToken = URLDecoder.decode(UcAuthCode.authcodeDecode(qqCode, "weizy2015"), "utf-8");
            if (openIdAndToken.split(",").length != 2) {
                return new ResponseEntity(new Message<>(Message.STATE_FALSE, "授权失败，请检查code"), HttpStatus.OK);
            }
            String openId = openIdAndToken.split(",")[0];
            String accessToken = openIdAndToken.split(",")[1];
            QQConnect connect = new QQConnect(SYS_GLOBAL.getConfig("qq.open.weizy.appid"),
                    SYS_GLOBAL.getConfig("qq.open.weizy.appKey"));
            Result<com.belerweb.social.qq.connect.bean.User> result = connect.getUser().getUserInfo(accessToken, openId);
            com.belerweb.social.qq.connect.bean.User soUser = result.getResult();
            User qqUser = (User) soUser;
            qqUser.setOpenid(openId);
            loginUserBean.setQqUser(qqUser);
        }

        Message message = userService.login(loginUserBean);//默认不用同步登录(不返回js 代码)
        return new ResponseEntity(message, HttpStatus.OK);
    }


    /**
     * 登出  todo 后期添加token 过期等操作
     *
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public ResponseEntity loginOut(String userId) {
        Message message = userService.loginOut(userId);
        return new ResponseEntity(message,HttpStatus.OK);
    }


    /**
     * 检查手机号码是否可以注册
     *
     * @return
     */
    @RequestLimit(count = 10,time = 60000)
    @RequestMapping(value = "/exitByPhone", method = RequestMethod.GET)
    public ResponseEntity exitByPhone(String phone) {
        boolean boo = userService.userExistByPhone(phone);
        Message msg = boo?new Message(Message.STATE_FALSE,"号码"+phone+"已注册"):new Message(Message.STATE_TRUE,"此号码可使用");
        return new ResponseEntity(msg, HttpStatus.OK);
    }

    /**
     * 号码注册
     *
     * @return
     */
    @RequestLimit(count = 10,time = 60000)
    @RequestMapping(value = "/registerByPhone", method = RequestMethod.POST)
    public ResponseEntity register(@RequestParam(value = "phone",required = true) String phone,
                                   @RequestParam(value = "password",required = true)String password) {
        String pwd = new String(Base64.decodeBase64(password));
        Message message = userService.registerByPhone(phone, pwd);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    /**
     * 取得用户信息(本人)
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestHeader ("Authorization") String authorization) {
        String uid = getUserIdByAuthStr(authorization);
        Message message = userService.getUser(uid);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    /**
     * 修改  此接口会重新更新token
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestHeader ("Authorization") String authorization,String password, UserModel userModel,HttpServletRequest request) {

        String uid = getUserIdByAuthStr(authorization);
        Map map = new HashMap<>();
        map.put("clientVersion",request.getParameter("clientVersion"));
        map.put("lastLoginIp",NetworkUtil.getIpAddress(request));
        if(StringUtils.isNotBlank(password)){
            map.put("password",new String(Base64.decodeBase64(password)));
        }
        userModel.setId(uid);
        Message message = userService.updateUser(userModel,map);
        return new ResponseEntity(message, HttpStatus.OK);
    }


    /**
     * 头像修改
     */
    @RequestMapping(value = "/avatar", method = RequestMethod.PUT)
    public ResponseEntity updateAvatar(@RequestParam MultipartFile file,@RequestHeader ("Authorization") String authorization,HttpServletRequest request) throws IOException, UploadException {
        String uid = getUserIdByAuthStr(authorization);


        UploadFileImgBean uploadFileImgBean = new UploadFileImgBean();
        uploadFileImgBean.setFileMaxSize(new Long(1024 * 1024 * 5));//文件最大5M
        uploadFileImgBean.setImgScaleBean(Constant.SCALA_SIZE_DEFAULT);//0.5倍压缩
        uploadFileImgBean.setModel(Constant.UPLOAD_MODEL_IMG_HEAD);
        String[] imgArr = commonService.uploadImg(request, file, uploadFileImgBean);

        System.out.println(authorization);

        UserModel userModel = new UserModel();
        userModel.setId(uid);
        userModel.setAvatar(imgArr[0]);
        Message message = userService.updateUser(userModel, null);
        if(message.isSuccess()){
            return new ResponseEntity(new Message<>(Message.STATE_TRUE, imgArr[0]), HttpStatus.OK);
        }else{
            return new ResponseEntity(new Message<>(Message.STATE_FALSE,"修改失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * 找回密码
     *
     * @return
     */
    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    public ResponseEntity findPwd(@RequestHeader ("Authorization") String authorization) {
        String uid = getUserIdByAuthStr(authorization);
        return null;
    }


    /**
     * 刷新token
     */
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResponseEntity refreshToken(@RequestHeader ("Authorization") String authorization,String version) {
        String uid = getUserIdByAuthStr(authorization);
        Message message = userService.refreshToken(uid,version);
        return new ResponseEntity(message,HttpStatus.OK);
    }


    private String getUserIdByAuthStr(String authorization){
        Jws<Claims> claimsJws = JwtUtil.parseToken(authorization, jwtSecret);
        JwtUtil.TokenBody body = JwtUtil.getBody(claimsJws);
        return body.getUid();
    }
}
