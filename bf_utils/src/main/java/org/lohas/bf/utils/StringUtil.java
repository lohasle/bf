package org.lohas.bf.utils;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lohas on 2015/3/30.
 */
public class StringUtil {
    /**
     * 产生一个随机的字符串
     */
    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(str.length());
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }


    // 只允许字母和数字
    // String   regEx  =  "[^a-zA-Z0-9]";
    // 清除掉所有特殊字符
    public static String StringFilter(String str) {
        return str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5_]+", "");  //替换特殊字符
    }


    /**
     * 产生一个随机的整数字符串
     */
    public static String RandomIntString(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(str.length());
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }


    /**
     * 生成订单编号
     *
     * @return
     */
    public static String genOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String preStr = sdf.format(new Date());
        return preStr+RandomIntString(3);
    }

    /**
     * 匹配字符
     * @param str
     * @param strings
     * @return
     */
    public static boolean  equalsToStrArr(String str,String[] strings){
        for (String s:strings){
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }



}
