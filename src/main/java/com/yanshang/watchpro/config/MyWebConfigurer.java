package com.yanshang.watchpro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class MyWebConfigurer implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry){
//        /**
//         * 所有请求都允许跨域，使用这种配置就不需要
//         * 在interceptor中配置header了
//         */
//        corsRegistry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://wpro.zmox.cn/")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*")
//                .maxAge(3600);
//    }
//
//}