package org.lohas.bf.services;

import org.lohas.bf.constant.exception.UploadException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.UploadFileImgBean;
import org.lohas.bf.security.HttpSessionKey;
import org.lohas.bf.services.base.BasicService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lohas on 2015/3/13.
 */
public interface CommonService extends BasicService {

    /**
     * 上传图片
     * @param request
     * @param file
     * @param uploadFileImgBean
     * @return  两张图  一张大图  一张压缩图
     * @throws IOException
     * @throws UploadException
     */
    String[] uploadImg(HttpServletRequest request, MultipartFile file, UploadFileImgBean uploadFileImgBean) throws IOException, UploadException;

    /**
     * 上传文件
     * @param request
     * @param file
     * @param uploadRootPath  相对upload 的地址
     * @return
     */
    String uploadFile(HttpServletRequest request, MultipartFile file,String uploadRootPath) throws IOException;


    /**
     * 下载图片
     * 返回相对项目的跟路径的地址
     */
    String[] downloadImg(String url,String model) throws IOException;


    /**
     * 验证手机验证码
     * @return
     */
    Message vaildatePhoneYZM(String phone,String yzm,HttpSessionKey sessionKey,HttpSession session);


}
