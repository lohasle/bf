package org.lohas.bf.spring.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lohas on 2015/10/21.
 * https://github.com/lohasle
 */
public class CustomAuthenticationFilter extends FormAuthenticationFilter {
    private Map<String, String> loginUrlByUserAgent = new HashMap<String, String>();

    public void setLoginUrls(final Map<String, String> loginUrlByUserAgent) {
        this.loginUrlByUserAgent = loginUrlByUserAgent;
    }

    protected void redirectToLogin(final ServletRequest request, final ServletResponse response) throws IOException {
        final String loginUrl = getLoginUrl(request);
        WebUtils.issueRedirect(request, response, loginUrl);
    }

    private String getLoginUrl(final ServletRequest request) {
        // check user agent
        final String userAgent = getUserAgent(request);
        // and return appropriate login url
        return userAgent != null && loginUrlByUserAgent.containsKey(userAgent) ?
                loginUrlByUserAgent.get(userAgent) :
                getLoginUrl();
    }

    // 根据UA 来判断来至PC mobile 还是 APP
    private String getUserAgent(final ServletRequest request) {
        // get "User-Agent" header
        return "android";
    }
}
