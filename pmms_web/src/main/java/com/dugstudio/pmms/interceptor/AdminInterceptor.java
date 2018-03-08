package com.dugstudio.pmms.interceptor;

import com.dugstudio.pmms.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements CommonInterceptor {
    @Override
    public boolean interceptor(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User u=(User)request.getSession().getAttribute("user");
        if (u==null||u.getIsAdmin()==0){
            System.out.println("AdminInterceptor not admin");
            response.sendRedirect("/front/user/index.do");
            return false;
        }
        System.out.println("AdminInterceptor  is admin");
        return true;
    }
}
