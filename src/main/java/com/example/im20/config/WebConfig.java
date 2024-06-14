package com.example.im20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS(Cross-Origin Resource Sharing)
 * 웹 브라우저에서 보안상의 이유로 도메인이 다른 서버에 요청을 보낼 때
 * 발생하는 문제를 해결하기 위한 메커니즘
 *
 * 동일 출처 정책(Same-Origin Policy)
 * 기본적으로 웹 브라우저는 다른 도메인, 프로토콜 또는 포트에서
 * 리소스를 요청하는 것을 제한함
 *
 * 필요한 이유
 * 다른 출처에서 데이터를 가져와야 할 필요가 있음 -> 이때 CORS가 필요
 * CORS는 서버가 특정 출처의 요청을 허용할 수 있도록 HTTP 헤더를 통해 브라우저와 통신
 *
 * allowedOrigins() : 특정 출처를 허용
 * allowedMethods() : 허용되는 Http 메소드 유형
 * allowedHeaders() : 허용되는 HTTP 헤더를 명시
 * allowCredentials() : 자격 증명(쿠키, HTTP 인증 등)을 포함한 요청을 허용할지 여부를 명시
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                        .allowedHeaders("*")
                        .allowCredentials(true);

                // 다른 출처에 대한 포괄적인 CORS 설정을 제거하고 필요한 경우 추가 설정을 명시적으로 작성하십시오.
                // registry.addMapping("/**")
                //         .allowedOrigins("*")
                //         .allowedMethods("*")
                //         .allowedHeaders("*")
                //         .allowCredentials(false);
            }
        };
    }
}

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                // localhost:8080에서 오는 요청에 대한 CORS 설정
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8080")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
//                        .allowedHeaders("*")
//                        .allowCredentials(true);
//
//                // 다른 모든 출처에 대한 포괄적인 CORS 설정
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("*")
//                        .allowedHeaders("*")
//                        .allowCredentials(false);
//            }
//        };
//    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8080")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedHeaders("*")
//                        .allowCredentials(true);
//            }
//        };
//    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
//            }
//        };
//    }

