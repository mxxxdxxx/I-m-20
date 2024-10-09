package com.example.im20.service;

import com.example.im20.entity.User;
import com.example.im20.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String profilePicture = oAuth2User.getAttribute("picture");

        // 사용자가 DB에 있는지 확인
        Optional<User> userOptional = userRepository.findByUserEmail(email);
        User user;

        if (userOptional.isPresent()) {
            // 기존 사용자 정보 업데이트 로직이 필요할 경우 추가
            user = userOptional.get();
        } else {
            // 새로운 사용자 저장
            user = User.builder()
                    .userEmail(email)
                    .userName(name)
                    .userProfilePhoto(profilePicture)
                    .userLoginType(1) // 소셜 로그인 타입, 구글이면 1로 설정
                    .build();
            userRepository.save(user);
        }

        return new DefaultOAuth2User(
                Collections.singleton(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(),
                "name" // OAuth2User에서 사용할 기본 키
        );
    }
}
