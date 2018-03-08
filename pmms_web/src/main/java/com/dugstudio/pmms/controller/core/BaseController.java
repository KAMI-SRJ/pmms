package com.dugstudio.pmms.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    @ExceptionHandler
    public void exceptionHandler(Exception e){
        e.printStackTrace();
    }
    /**
     * 判断是否是AJAX请求
     * @return true ajax
     */
    protected boolean isAjaxRequest(){
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(header) ? true : false;
    }
}
