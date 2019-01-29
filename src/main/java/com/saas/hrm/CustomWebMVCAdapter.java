package com.saas.hrm;

import com.saas.hrm.interceptor.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 16:27
 * @Description:
 */
@Component
public class CustomWebMVCAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**").excludePathPatterns("/sys/user/login");
    }
}
