package com.example.im20.controller;

import com.example.im20.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class VerificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendVerificationCode")
    public String sendVerificationCode(@RequestParam String email) {
        emailService.sendVerificationEmail(email);
        return "Verification code sent to " + email;
    }

    @PostMapping("/verifyCode")
    public String verifyCode(@RequestParam String email, @RequestParam String code) {
        boolean isValid = emailService.verifyCode(email, code);
        return isValid ? "Verification successful" : "Invalid verification code";
    }
}
