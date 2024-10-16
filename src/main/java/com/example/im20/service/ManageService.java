package com.example.im20.service;

import com.example.im20.dto.ManageDTO;
import com.example.im20.entity.Manage;
import com.example.im20.entity.User;
import com.example.im20.repository.ManageRepository;
import com.example.im20.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ManageService {

    @Autowired
    private ManageRepository manageRepository;

    @Autowired
    private UserRepository userRepository;

    // 새로운 Manage 엔티티 생성 및 저장
    @Transactional
    public ManageDTO startTraining(Integer userId, LocalDate date) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 ID입니다."));

        // 주어진 날짜에 해당 사용자의 Manage 엔티티가 있는지 확인
        Optional<Manage> existingManage = manageRepository.findByUserIdAndManageDate(userId, date);
        if (existingManage.isPresent()) {
            return new ManageDTO(existingManage.get()); // 이미 있는 경우 해당 엔티티 반환
        }

        // 없으면 새로운 Manage 엔티티 생성 및 저장
        Manage manage = Manage.builder()
                .user(user)
                .manageDate(date)
                .build();

        Manage savedManage = manageRepository.save(manage);
        return new ManageDTO(savedManage); // 새로운 Manage 엔티티 반환
    }

    // 특정 날짜에 대한 모든 훈련 정보 조회
    @Transactional
    public ManageDTO getTrainingsForDate(Integer userId, LocalDate date) {
        Manage manage = manageRepository.findByUserIdAndManageDate(userId, date)
                .orElseThrow(() -> new IllegalArgumentException("해당 날짜에 훈련 정보가 없습니다."));

        // Manage 엔티티에서 훈련 데이터 가져와서 DTO로 변환
        return new ManageDTO(manage);
    }
}

//    @Autowired
//    private ManageRepository manageRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // 새로운 Manage 엔티티 생성 및 저장
//    @Transactional
//    public ManageDTO startTraining(Integer userId, LocalDate date) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 ID입니다."));
//
//        // 주어진 날짜에 해당 사용자의 Manage 엔티티가 있는지 확인
//        Optional<Manage> existingManage = manageRepository.findByUserIdAndManageDate(userId, date);
//        if (existingManage.isPresent()) {
//            return new ManageDTO(existingManage.get()); // 이미 있는 경우 해당 엔티티 반환
//        }
//
//        // 없으면 새로운 Manage 엔티티 생성 및 저장
//        Manage manage = Manage.builder()
//                .user(user)
//                .manageDate(date)
//                .build();
//
//        Manage savedManage = manageRepository.save(manage);
//        return new ManageDTO(savedManage); // 새로운 Manage 엔티티 반환
//    }
//
//    // 특정 날짜에 대한 모든 훈련 정보 조회
//    @Transactional
//    public ManageDTO getTrainingsForDate(Integer userId, LocalDate date) {
//        Manage manage = manageRepository.findByUserIdAndManageDate(userId, date)
//                .orElseThrow(() -> new IllegalArgumentException("해당 날짜에 훈련 정보가 없습니다."));
//
//        // Manage 엔티티에서 훈련 데이터 가져와서 DTO로 변환
//        return new ManageDTO(manage);
//    }
//}
