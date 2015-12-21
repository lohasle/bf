package org.lohas.bf;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by lohas on 2015/5/15.
 * https://github.com/lohasle
 */
public class AppTest {
    @Test
    public void testApp(){
        String str1="李哈哈哈哈哈哈哈哈哈李哈哈哈哈哈哈哈哈哈李哈哈哈李哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈& lt;br /& gt;\n" +
                "& lt;br /& gt;\n" +
                "& lt;a href=\"http://www.weizy.cn\" target=\"_blank\"& gt;来自微中医APP& lt;/a& gt;";
        String str2="& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"8\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;& lt;img src=\"static/image/smiley/default/titter.gif\" smilieid=\"9\" border=\"0\" alt=\"\" /& gt;;P& lt;br /& gt;\n" +
                "的发送到发送到发送到发的啥方法& lt;br /& gt;\n" +
                "倒萨得到大叔是的& lt;br /& gt;\n" +
                "大萨达萨达萨达打算打算& lt;br /& gt;\n" +
                "打算打算打算打算& lt;br /& gt;\n" +
                "& lt;img id=\"aimg_KOsZN\" onclick=\"zoom& #40;this, this.src, 0, 0, 0& #41;\" class=\"zoom\" src=\"http://119.29.19.92/uc_server/images/noavatar_middle.gif\" onmouseover=\"img_onmouseoverfunc& #40;this& #41;\" onload=\"thumbImg& #40;this& #41;\" border=\"0\" alt=\"\" /& gt; ";

        String str3="大萨达萨达萨达";

//        System.out.println(clearNotChinese(str1));

        //只保留中文
        System.out.println(str1.replaceAll("(\\s[^\u4E00-\u9FA5]+)|([^\u4E00-\u9FA5]+\\s)", ""));
        System.out.println(str2.replaceAll("(\\s[^\u4E00-\u9FA5]+)|([^\u4E00-\u9FA5]+\\s)", ""));
        System.out.println(str3.replaceAll("(\\s[^\u4E00-\u9FA5]+)|([^\u4E00-\u9FA5]+\\s)", ""));

        System.out.println("---------->");

        //替换
        System.out.println(str1.replaceAll("[ (\"&gt ;\"& lt;a href=\\\"http://www.weizy.cn\\\" target=\\\"_blank\\\"& gt;来自微中医APP& lt;/a& gt;\")]", ""));
        System.out.println("---------->");

        System.out.println(str2.replaceAll("(& lt;img src=\"static/image/smiley/default/.+)gif\"+(.)+/& gt;","[表情]"));

        System.out.println("---------->");

        System.out.println(str2.replaceAll("(& lt;img.+)(src=\"http.+)(gif|jpg|png)\"+(.)+/& gt;","[图片]"));


        //综合
        String  testStr = str1+str2+str3;

        //替换表情
        testStr = testStr.replaceAll("(& lt;img src=\"static/image/smiley/default/.+)gif\"+(.)+/& gt;","[表情]");

        //替换 图片
        testStr = testStr.replaceAll("(& lt;img src=\"static/image/smiley/default/.+)gif\"+(.)+/& gt;","[表情]");

        //替换 app 字样
        testStr = testStr.replaceAll("[ (\"&gt ;\"& lt;a href=\\\"http://www.weizy.cn\\\" target=\\\"_blank\\\"& gt;来自微中医APP& lt;/a& gt;\")]","");

        //替换特殊字符
        testStr = testStr.replaceAll("& lt;br /& gt;","");


        System.out.println("\n\n-------------------------------------->");
        System.out.println(testStr);

    }


    /**
     * 去除“第”之前的所有非汉字内容
     */
    private String clearNotChinese(String buff){
        String tmpString =buff.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");//去掉所有中英文符号
        char[] carr = tmpString.toCharArray();
        for(int i = 0; i<tmpString.length();i++){
            carr[i] = ' ' ;//过滤掉非汉字内容
        }
        return String.copyValueOf(carr).trim();
    }
}
