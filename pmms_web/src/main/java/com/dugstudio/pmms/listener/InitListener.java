package com.dugstudio.pmms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static com.dugstudio.pmms.util.Constant.*;

public class InitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("InitListener contextInitialized");
        PATH=sce.getServletContext().getContextPath();
        sce.getServletContext().setAttribute("path", PATH);
        HALF_PATH="users";
        sce.getServletContext().setAttribute("half_path", HALF_PATH);
        JSP_NAME="page";
        sce.getServletContext().setAttribute("jsp_name", JSP_NAME);
        System.out.println("path:"+PATH);
        System.out.println("half_pATH"+HALF_PATH);
        System.out.println("page:"+JSP_NAME);
    }

}
