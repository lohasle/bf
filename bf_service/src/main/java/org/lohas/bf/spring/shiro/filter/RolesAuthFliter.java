package org.lohas.bf.spring.shiro.filter;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 * Created by lohas on 2015/10/21.
 * https://github.com/lohasle
 */
public class RolesAuthFliter extends RolesAuthorizationFilter {
    @Override
    public void setLoginUrl(String loginUrl) {
        super.setLoginUrl(loginUrl);
    }

    @Override
    public String getLoginUrl() {
        return super.getLoginUrl();
    }

    @Override
    public void setUnauthorizedUrl(String unauthorizedUrl) {
        super.setUnauthorizedUrl(unauthorizedUrl);
    }

    @Override
    public String getUnauthorizedUrl() {
        return super.getUnauthorizedUrl();
    }
}
