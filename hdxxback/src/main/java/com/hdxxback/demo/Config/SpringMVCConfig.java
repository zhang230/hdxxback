package com.hdxxback.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 启用跨域配置
 * 编写SpringMVCConfig类使用FilterConfig中的配置
 * @author zsh
 *
 */
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(new FilterConfig());
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

}