package com.stone.sjwt;

import com.stone.sjwt.interceptor.AuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SjwtApplication {

    public static void main(String[] args) {

        SpringApplication.run(SjwtApplication.class, args);
    }

    @Bean
    public WebMvcConfigurerAdapter interceptorConfig() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/api/data/save/**");
                super.addInterceptors(registry);
            }
        };
    }
}
