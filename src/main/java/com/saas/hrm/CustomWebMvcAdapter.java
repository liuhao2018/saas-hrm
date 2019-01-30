package com.saas.hrm;

import com.saas.hrm.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 16:27
 * @Description:
 */
@Component
public class CustomWebMvcAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/sys/user/login");
    }
}
