package com.example.im20.config;

import com.example.im20.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public WebConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 비활성화
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/login", "/oauth2/**", "/email/**").permitAll()  // 로그인 및 특정 요청 허용
                        .anyRequest().authenticated()  // 그 외 요청은 인증 필요
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")  // 로그인 페이지 설정
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)  // CustomOAuth2UserService로 사용자 정보 처리
                        )
                        .successHandler((request, response, authentication) -> {
                            // 로그인 성공 후 처리 로직
                            response.sendRedirect("/home");
                        })
                );

        return http.build();
    }
}
