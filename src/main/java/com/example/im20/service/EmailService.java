package com.example.im20.service;

import com.example.im20.entity.VerificationCode;
import com.example.im20.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    public String sendVerificationEmail(String toEmail) {
        String verificationCode = generateVerificationCode();

        // 인증 코드 저장
        VerificationCode code = new VerificationCode();
        code.setEmail(toEmail);
        code.setCode(verificationCode);
        code.setExpirationTime(LocalDateTime.now().plusMinutes(5)); // 5분 동안 유효

        verificationCodeRepository.save(code);

        // TODO: 이메일 전송 로직을 여기에 추가

        return verificationCode;
    }

    public boolean verifyCode(String email, String code) {
        return verificationCodeRepository.findById(email)
                .map(verificationCode ->
                        verificationCode.getCode().equals(code) &&
                                verificationCode.getExpirationTime().isAfter(LocalDateTime.now()))
                .orElse(false);
    }

    private String generateVerificationCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000); // 6자리 랜덤 숫자 생성
    }
}
