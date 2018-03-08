package com.dugstudio.pmms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonInterceptor {
    boolean interceptor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception;
}
