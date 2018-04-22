package service.security.shiro;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShiroFilter extends AccessControlFilter {
    private String phssLoginUrl = "/user/login";

    public ShiroFilter() {
    }

    @Override
    public String getLoginUrl() {
        return this.phssLoginUrl;
    }

    @Override
    public void setLoginUrl(String loginUrl) {
        this.phssLoginUrl = loginUrl;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        return getSubject(servletRequest, servletResponse) != null && getSubject(servletRequest, servletResponse).isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }


}
