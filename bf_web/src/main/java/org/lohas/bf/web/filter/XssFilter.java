package org.lohas.bf.web.filter;

import org.lohas.bf.web.wrapper.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by lohas on 2015/3/9.
 */
public class XssFilter implements Filter {
    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 忽略媒体文件
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String urlValue = servletRequest.getRequestURI().replaceAll("//", "/");
        Pattern p = Pattern.compile(".*|jpg|png|gif|bmp|amr|mp4");
        if (p.matcher(urlValue.toLowerCase()).matches()) {
            chain.doFilter(request, response);//继续执行
        }else{
            chain.doFilter(new XssHttpServletRequestWrapper(
                    (HttpServletRequest) request), response);
        }
    }
}
