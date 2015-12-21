package org.lohas.bf.spring;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.utils.NetworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: fule
 * @version: Revision 1.0.0
 * @see:
 * @创建日期:14-1-18
 * @功能说明: web 工具类
 */
public class WebUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    /**
     * ip 缓存
     */
    private static Map ipCacheMap = new ConcurrentHashMap();


    /**
     * 取得当前request
     *
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) ra).getRequest();
    }

    /**
     * 得到网站 根路径（绝对路径）
     *
     * @return
     */
    public static String getWebRootRealPath() {
        return getHttpServletRequest().getServletContext().getRealPath("/");
    }


    /**
     * 得到网站 网络跟地址(网络地址)
     *
     * @return
     */
    public static String getWebRootUrlPath() {
        HttpServletRequest request = getHttpServletRequest();
        String host = "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath();
        return host;
    }


    /**
     * 以JSON格式输出
     *
     * @param response
     */
    public static void responseOutWithJson(HttpServletResponse response,
                                           Object responseObject) {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JSONObject.toJSONString(responseObject));
            out.flush();
//            response.reset();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("responseOutWithJson----->输出json异常");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    // 输出字符
    public static void responseOutWithStr(HttpServletResponse response,
                                          String jsonStr) {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(jsonStr);
            out.flush();
//            response.reset();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("responseOutWithJson----->输出json异常");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 跳转到指定地址
     *
     * @param response
     * @param url
     */
    public static void jumpUrl(HttpServletResponse response,
                               String url, String msg) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print("<html>" +
                    "<head>" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">" +
                    "</head>" +
                    "<body>" +
                    "<script type=\"text/javascript\">location.href=\"" + url + "\"</script>" +
                    msg + "</body>" +
                    "</html>");
            printWriter.flush();
            printWriter.close();
            response.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行脚本
     *
     * @param response
     * @param jscript  脚本
     */
    public static void printScript(HttpServletResponse response, String jscript) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print("<html>" +
                    "<head>" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">" +
                    "</head>" +
                    "<script type=\"text/javascript\">" + jscript + "</script>" +
                    "</html>");
            printWriter.flush();
            printWriter.close();
            response.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 取得session 数据 并清除
     */
    public static Object getAttributeAndRemove(HttpSession session, String sessionKey) {
        Object result = session.getAttribute(sessionKey);
//        session.removeAttribute(sessionKey);
        return result;
    }


    /**
     * 读取request body 内容到字符
     *
     * @param request
     */
    public static String readRequestBody(HttpServletRequest request) throws IOException {
        InputStream in = request.getInputStream();
        String result = IOUtils.toString(in);
        return result;
    }


    /**
     * 判断是否是微信浏览器
     *
     * @param request
     * @return
     */
    public static boolean isWeXinBrowser(HttpServletRequest request) {
        String ua = request.getHeader("user-agent")
                .toLowerCase();
        if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
            return true;
        }
        return false;
    }

    //输出没有权限访问  默认输出没有权限访问
    public static void responseNoPermission(HttpServletResponse response, Message object) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        WebUtils.responseOutWithJson(response, object);
    }

    /**
     * 检查某一个请求 指定ip  指定时间期内 可访问的次数
     * ip ip地址
     * reqName 请求别名
     *
     * @param maxCount 最多请求次数
     * @param maxTime  单位时间
     * @return true 通过限制  fasle 检查不通过
     */
    public static Message VaildIpReqCountOnDay(HttpServletRequest request, int maxCount, long maxTime) {
        // ip 检测 一段时间请求次数
        String ip = NetworkUtil.getIpAddress(request);
        String reqName = request.getRequestURI();
        String key = ip + "_" + reqName;  // 缓存ip 的别名 key
        Map ipSessionObj = (Map) ipCacheMap.get(key);
        if (ipSessionObj == null) {
            //第一次请求
            ipSessionObj = new ConcurrentHashMap();
            ipSessionObj.put("count", 0);  //次数
            ipSessionObj.put("date", new Date());//时间
            ipCacheMap.put(key, ipSessionObj);
//            System.out.println("---true0-->"+ipSessionObj);
            return new Message(Message.STATE_TRUE, "");
        } else {
            //检查是否过了单位时间
            Date crdate = (Date) ipSessionObj.get("date");
            Date newDate = new Date();
          /*  System.out.println("---->" + (crdate.getTime() + maxTime));
            System.out.println("---->" + newDate.getTime());
            System.out.println("---->" + ((crdate.getTime() + maxTime) < newDate.getTime()));*/
            if ((crdate.getTime() + maxTime) < newDate.getTime()) {
                //过了限制时间 更新
                ipSessionObj.put("count", 0);  //次数
                ipSessionObj.put("date", new Date());//时间
                ipCacheMap.put(key, ipSessionObj);
//                System.out.println("---true1-->"+ipSessionObj);
                return new Message(Message.STATE_TRUE, "");
            } else {
                // 限制时间之内检查次数
                Integer count = (Integer) ipSessionObj.get("count");
                ipSessionObj.put("count", ++count);
                if (count >= maxCount) {
                    Double d1 = Double.valueOf(maxTime - (newDate.getTime() - crdate.getTime()));
                    Double d2 = Double.valueOf(1000 * 60 * 60); //单位小时
                    DecimalFormat df2 = new DecimalFormat("###.00");
                    String syTime = df2.format(d1 / d2);//剩余时间
                    logger.info("---ip:" + ip + " 请求： " + key + " 请求次数超过" + maxCount + " 次，请过" + Float.parseFloat(syTime) + "小时再访问");
                    return new Message(Message.STATE_FALSE, " 请求次数超过" + maxCount + " 次，请过" + Float.parseFloat(syTime) + "小时再访问");
                } else {
//                    System.out.println("---true2-->"+ipSessionObj);
                    return new Message(Message.STATE_TRUE, "");
                }
            }

        }
    }
}
