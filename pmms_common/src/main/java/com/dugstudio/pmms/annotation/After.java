package com.dugstudio.pmms.annotation;

import com.dugstudio.pmms.interceptor.CommonInterceptor;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface After {
    Class<? extends CommonInterceptor> value();
}
