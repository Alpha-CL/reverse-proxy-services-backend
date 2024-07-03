package com.example.services.config.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * add Cors Mappings
     *
     * @param registry 注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径
        registry.addMapping("/**")
                // 是否发送Cookie
                .allowCredentials(true)
                // 设置放行哪些原始域
                .allowedOrigins("*")
                // 放行哪些请求方式
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                //.allowedMethods("*") //或者放行全部
                // 放行哪些原始请求头部信息
                .allowedHeaders("*")
                // 暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }
}