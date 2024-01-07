package com.zzz.pms.sys.configuration;

import com.zzz.pms.sys.common.LogIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Bean
    public LogIntercepter logIntercepter() {
        return new LogIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logIntercepter());
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
