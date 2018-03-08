package com.dugstudio.pmms.interceptor;

import com.dugstudio.pmms.annotation.After;
import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.annotation.Clear;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InitInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("InitInterceptor preHandle");
        if (handler != null) {
            System.out.println("handler != null");
            List<Annotation> annotationList = new ArrayList<>();
            if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Class clazz = ((HandlerMethod) handler).getMethod().getDeclaringClass();
                Annotation[] classAnnotations = clazz.getAnnotations();
                for (Annotation annotation : classAnnotations) {
                    annotationList.add(annotation);
                    System.out.println("annotationType:"+annotation.annotationType());
                }
                Annotation[] methodAnnotations = ((HandlerMethod) handler).getMethod().getAnnotations();
                for (Annotation annotation : methodAnnotations) {
                    annotationList.add(annotation);
                    System.out.println("methodAnnotations:"+annotation.annotationType());
                }
                System.out.println(annotationList.size());
                for (int i = 0; i < annotationList.size(); i++) {
                    boolean hasClear = false;
                    Annotation annotation = annotationList.get(i);
                    //获取Before注解
                    Before before = null;
                    try {
                        before = (Before) annotation;
                    } catch (Exception e) {
                        System.out.println("  before = (Before) annotation;======================="+annotation.annotationType());
                    }
                    if (before != null) {
                        for (int j = i + 1; j < annotationList.size(); j++) {
                            System.out.println("before annotation not null"+annotationList.size());
                            Annotation annotation1 = annotationList.get(j);
                            System.out.print("--annotation1:-"+annotation1);
                            Clear clear = null;
                            try {
                                clear = (Clear) annotation1;
                            } catch (Exception e) {

                            }
                            if (clear != null) {
                                hasClear = true;
                                break;
                            }
                        }
                        //在@Before注解后面如果有@Clear注解，该注解就无效
                        if (!hasClear) {
                            System.out.println("clear annotation == null");
                            Class<? extends CommonInterceptor> interceptorlll = before.value();
                            Object object = Class.forName(interceptorlll.getCanonicalName()).newInstance();
                            Class[] clazzs = new Class[]{HttpServletRequest.class, HttpServletResponse.class, Object.class};
                            Method method = object.getClass().getMethod("interceptor", clazzs);
                            Object[] params = new Object[]{request, response, handler};
                            boolean result = (boolean) method.invoke(object, params);
                            return result;
                        }
                    }
                }
            }
        }
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        System.out.println("InitInterceptor afterCompletion");

        if (handler != null) {
            List<Annotation> annotationList = new ArrayList<>();
            if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Class clazz = ((HandlerMethod) handler).getMethod().getDeclaringClass();
                Annotation[] classAnnotations = clazz.getAnnotations();
                for (Annotation annotation : classAnnotations) {
                    System.out.println("afterCompletion classAnnotations::::"+annotation.annotationType());
                    annotationList.add(annotation);
                }
                Annotation[] methodAnnotations = ((HandlerMethod) handler).getMethod().getAnnotations();
                for (Annotation annotation : methodAnnotations) {
                    System.out.println("afterCompletion methodAnnotations::::"+annotation.annotationType());
                    annotationList.add(annotation);
                }
                System.out.println("afterCompletion annotationList.size()"+annotationList.size());
                for (int i = 0; i < annotationList.size(); i++) {
                    boolean hasClear = false;
                    Annotation annotation = annotationList.get(i);
                    //获取After注解
                    After after = null;
                    try {
                        after = (After) annotation;
                    } catch (Exception e1) {
                        System.out.println("error !!!"+annotation.annotationType());
                    }
                    if (after != null) {
                        System.out.println("after not null"+annotationList.size());
                        for (int j = i + 1; j < annotationList.size(); j++) {
                            Annotation annotation1 = annotationList.get(j);
                            Clear clear = null;
                            try {
                                clear = (Clear) annotation1;
                            } catch (Exception e1) {

                            }
                            if (clear != null) {
                                hasClear = true;
                                break;
                            }
                        }
                        //在@After注解后面如果有@Clear注解，该注解就无效
                        if (!hasClear) {
                            System.out.println("clear ==null");
                            Class<? extends CommonInterceptor> interceptorlll = after.value();
                            Object object = Class.forName(interceptorlll.getCanonicalName()).newInstance();
                            Class[] clazzs = new Class[]{HttpServletRequest.class, HttpServletResponse.class, Object.class};
                            Method method = object.getClass().getMethod("interceptor", clazzs);
                            Object[] params = new Object[]{request, response, handler};
                            method.invoke(object, params);
                        }
                    }
                }
            }
        }
    }
}
