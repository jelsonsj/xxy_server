package com.xxy.api.config;

import com.xxy.api.interceptor.BackendInterceptor;
import com.xxy.api.interceptor.FrontendInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@Component
public class WebInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public BackendInterceptor backendInterceptor()
    {
        return new BackendInterceptor();
    }

    @Bean
    public FrontendInterceptor frontendInterceptor()
    {
        return new FrontendInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(frontendInterceptor())
                .addPathPatterns("/frontend/**","/getDrawInfo")
                .excludePathPatterns("/v1/login","/ws/*","/wss/*","/app/shutdown","/admin/user/getHSIDate","/websocket","/bgadmin/*");

        registry.addInterceptor(backendInterceptor())
                .addPathPatterns("/backend/**")
                .excludePathPatterns("/backend/v1/login","/frontend/*","/backend/user/getHSIDate");
    }
}
