package com.example.im20.service;

import com.example.im20.entity.VerificationCode;
import com.example.im20.repository.VerificationCodeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

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

        // 이메일 전송 로직 추가
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(toEmail);
            helper.setSubject("Verification Code");
            helper.setText("Your verification code is: " + verificationCode, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send verification email.";
        }

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
        return String.valueOf((int) (Math.random() * 900000) + 100000); // 6자리 랜덤 숫자 생성
    }
}
