package com.example.im20.service;

import com.example.im20.entity.*;
import com.example.im20.repository.ManageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageService {

    private final UserService userService;
    private final ManageRepository manageRepository;

    public ManageService(UserService userService, ManageRepository manageRepository) {
        this.userService = userService;
        this.manageRepository = manageRepository;
    }

    public Manage createManage(Integer userId, Date manageDate, List<BreathingTraining> breathingTrainings, List<FluencyTraining> fluencyTrainings, List<PronunciationTraining> pronunciationTrainings) {
        Optional<User> optionalUser = userService.findUserById(userId);
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

            // Manage 객체를 저장
            manageRepository.save(manage);

            return manage;
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }
}
