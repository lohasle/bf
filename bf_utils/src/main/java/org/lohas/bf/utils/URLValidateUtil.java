package org.lohas.bf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lohas on 2015/3/9.
 * url验证工具
 */
public class URLValidateUtil {

    private static Logger logger = LoggerFactory.getLogger(URLValidateUtil.class);

    /**
     * 地址匹配验证
     *
     * @param url
     * @param pattern 匹配的规则
     *                如
     *                a/b/c    完全匹配
     *                a/* 匹配某个地址下所有的地址
     *                a/b/c*  匹配开头
     *                a/*.json  匹配结尾
     * @return
     */
    public static boolean validate(String url, String pattern) {
        if (pattern == null || "".equals(pattern.trim())) {
            return true;
        }
        String str = getPatternStr(pattern);
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(url);
        return m.matches();
    }

    public static String getPatternStr(String pattern){
        // 1遇到 * 转成 .* 2遇到*.json 等后缀 加\\ 3单词加上（）
        String patternStr = "";
        String[] arr = pattern.split("/");
        for (int i=0,len=arr.length;i<len;i++){
            if("".equals(arr[i])){
                patternStr+="/";
            }else if("*".equals(arr[i])){
                patternStr+=".*";
            }else{
                arr[i] = arr[i].replaceAll("\\*","\\.*");
                patternStr += "("+arr[i]+")"+(i==len-1?"":"/");
            }
        }
        return patternStr;
    }

}
