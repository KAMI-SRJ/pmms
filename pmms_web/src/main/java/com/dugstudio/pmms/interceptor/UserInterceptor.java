package com.dugstudio.pmms.interceptor;

import com.dugstudio.pmms.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements CommonInterceptor {
    @Override
    public boolean interceptor(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User)request.getSession().getAttribute("user");
        if(user==null||user.getId()==null){
            System.out.println("UserInterceptor is null");
            response.sendRedirect("/front/user/index.do");
            return false;
        }
        System.out.println("UserInterceptor  is  success");
        return true;
    }
}
