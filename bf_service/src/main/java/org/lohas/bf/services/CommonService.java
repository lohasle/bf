package org.lohas.bf.services;

import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.security.HttpSessionKey;
import org.lohas.bf.services.base.BasicService;
import org.lohas.bf.utils.ucenterapi.Client;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lohas on 2015/3/13.
 */
public interface CommonService extends BasicService {


    /**
     * 获取UCenter 客户端
     *
     * @return
     */
    Client getUcClient();


    /**
     * 同步注册
     *
     * @param ucUserName
     * @param pwd
     * @return
     */
    Map ucSynRegister(String ucUserName, String pwd);

    /**
     *  注册
     * @param ucUserName
     * @param pwd
     * @return
     */
    Boolean ucSynRegister2(String ucUserName, String pwd);

    /**
     * ucenter  同步更新用户名
     * @param newUserName
     * @param ucToken
     * @return
     */
    String ucSynChangeName(String newUserName,String ucToken);

    /**
     * uc设置新的密码
     * @param newPwd
     * @param ucToken
     * @return
     */
    String ucUserSynRepwd(String newPwd,String ucToken);

    /**
     * discuz  用户名生成策略  同时注册
     *
     * @param userName 用户名
     * @param pwd      密码
     * @param type     策略类型   doctor 医生   wxUser 微信  user普通用户
     * @param count    运行次数
     * @return
     */
    String generateAndRegisterUcCode(String userName, String pwd, String type, int count);

    /**
     * 上传图片
     *
     * @param request
     * @param file
     * @param uploadFileImgBean
     * @return 两张图  一张大图  一张压缩图
     * @throws IOException
     * @throws UploadException
     */
    String[] uploadImg(HttpServletRequest request, MultipartFile file, UploadFileImgBean uploadFileImgBean) throws IOException, UploadException;

    /**
     * 上传文件
     *
     * @param request
     * @param file
     * @param uploadRootPath 相对upload 的地址
     * @return
     */
    String uploadFile(HttpServletRequest request, MultipartFile file, String uploadRootPath) throws IOException;


    /**
     * 下载图片
     * 返回相对项目的跟路径的地址
     */
    String[] downloadImg(String url, String model) throws IOException;


    /**
     * 验证手机验证码
     *
     * @return
     */
    Message vaildatePhoneYZM(String phone, String yzm, HttpSessionKey sessionKey, HttpSession session);


}
