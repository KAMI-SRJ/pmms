package com.dugstudio.pmms.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RememberAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        Subject subject = getSubject(request, response);
        System.out.println("-------------authorfilter   isAuthenticated="+subject.isAuthenticated()+" subject.isRemembered()= "+subject.isRemembered());
        return subject.isAuthenticated() || subject.isRemembered();
    }
}
