package com.dugstudio.pmms.annotation;

import com.dugstudio.pmms.interceptor.CommonInterceptor;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Before {
    Class<? extends CommonInterceptor> value();
}
