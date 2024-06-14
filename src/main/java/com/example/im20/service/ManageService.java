package com.example.im20.service;

import com.example.im20.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageService {

    private final UserService userService;

    public ManageService(UserService userService) {
        this.userService = userService;
    }

    public Manage createManage(Integer clientId, Date manageDate, List<BreathingTraining> breathingTrainings, List<FluencyTraining> fluencyTrainings, List<PronunciationTraining> pronunciationTrainings) {
        Optional<User> optionalUser = userService.findUserById(clientId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Manage 객체 생성 및 필드 설정
            Manage manage = Manage.builder()
                    .user(user)
                    .manageDate(manageDate)
                    .breathingTrainings(breathingTrainings)
                    .fluencyTrainings(fluencyTrainings)
                    .pronunciationTrainings(pronunciationTrainings)
                    .build();

            // 필요에 따라 Manage 객체를 저장하거나 다른 작업 수행

            return manage;
        } else {
            throw new IllegalArgumentException("User with ID " + clientId + " not found.");
        }
    }
}
