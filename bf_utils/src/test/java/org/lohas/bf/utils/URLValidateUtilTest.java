package org.lohas.bf.utils;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidateUtilTest {

    @Test
    public void testValidate() throws Exception {
        System.out.println(URLValidateUtil.validate("/a/b", "/a/b"));
        System.out.println(URLValidateUtil.validate("/a/b/2121/dasdasd", "/a/b/*/"));
        System.out.println(URLValidateUtil.validate("/a/b/c/asa", "/a/b/*"));
        System.out.println(URLValidateUtil.validate("/a/b/ccssss", "/a/b/cc*"));
        System.out.println(URLValidateUtil.validate("/a/b/cc/sasa.json", "/a/b/cc/*.json"));
        System.out.println(URLValidateUtil.validate("/a/b/cc21/sss/kk11.json", "/a/b/cc*/sss/kk*.json"));
    }


    @Test
    public void testValidate2() throws Exception {
        System.out.println(URLValidateUtil.getPatternStr("/a/b/\\d+"));
        System.out.println(URLValidateUtil.validate("/a/b/11", "/a/b/\\d+"));


        System.out.println(URLValidateUtil.getPatternStr("/mobile/*/login"));
        System.out.println(URLValidateUtil.validate("/mobile/doctor/login", "/mobile/*/login"));
    }

    @Test
    public void testGetPatternStr() throws Exception {
        System.out.println(URLValidateUtil.getPatternStr("/ab/sasa/*"));
        System.out.println(URLValidateUtil.getPatternStr("/ab/sasa/*/"));
        System.out.println(URLValidateUtil.getPatternStr("/ab/sasa/aa*"));
        System.out.println(URLValidateUtil.getPatternStr("/ab/sasa/*.json"));
        System.out.println(URLValidateUtil.getPatternStr("/ab/sasa/aa*/sas*/*.json"));
    }


    @Test
    public void test() throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("http://app.weizy.com.cn/mobile/doctor/list", "utf-8"));
        System.out.println(URLDecoder.decode("http%3A%2F%2Fapp.weizy.com.cn%2F%2Fserver%2Fmobile%2Fuser%2Fcenter", "utf-8"));


        String userName = "dada dasdsa 哈哈哈哈_  ❤";
        userName = userName.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”_]+","");

        System.out.println(userName);

    }

    @Test
    public void testUrl() throws UnsupportedEncodingException {
        String url  =  URLDecoder.decode("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe3f8b6c8312633be&redirect_uri=http%3A%2F%2Fapp.weizy.cn%2Fmobile%2Fwxauth&response_type=code&scope=snsapi_userinfo&state=%2Fmobile%2Fuser%3F,1,0,0#wechat_redirect", "utf-8");

        System.out.println(url);

    }


    @Test
    public void testUrl2() throws UnsupportedEncodingException {
        String url = "aaa.jpg";
        Pattern p = Pattern.compile(".*|jpg|png|gif|bmp|amr|mp4");
        Matcher m = p.matcher(url);
        System.out.println(m.matches());

    }
}