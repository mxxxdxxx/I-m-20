package com.example.im20.controller;

import com.example.im20.dto.FluencyTrainingDTO;
import com.example.im20.entity.FluencyTraining;
import com.example.im20.entity.Manage;
import com.example.im20.repository.BreathingTrainingRepository;
import com.example.im20.repository.FluencyTrainingRepository;
import com.example.im20.repository.ManageRepository;
import com.example.im20.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings/ft")
public class FluencyTrainingController {

    @Autowired
    private GameService gameService;

    @PostMapping("/{manageId}")
    public FluencyTraining saveFluencyTraining(@PathVariable Integer manageId, @RequestBody FluencyTrainingDTO fluencyTrainingDTO) {
        FluencyTraining fluencyTraining = toEntity(fluencyTrainingDTO);
        return gameService.saveFluencyTraining(fluencyTraining, manageId);
    }

    private FluencyTraining toEntity(FluencyTrainingDTO dto) {
        return FluencyTraining.builder()
                .fluencyTrainingId(dto.getFtId())
                .ftFeedback(dto.getFtFeedback())
                .manage(Manage.builder().manageId(dto.getManageId()).build())
                .build();
    }


//    @PostMapping("/{manageId}")
//    public FluencyTraining saveFluencyTraining(@PathVariable Integer manageId, @RequestBody FluencyTraining fluencyTraining) {
//        return gameService.saveFluencyTraining(fluencyTraining, manageId);
//    }

//    @PostMapping("/{manageId}")
//    public FluencyTraining saveFluencyTraining(@PathVariable Integer manageId, @RequestBody FluencyTraining fluencyTraining) {
//        // Manage 엔티티 조회
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//
//        // FluencyTraining 엔티티에 Manage 엔티티 설정
//        fluencyTraining.setManage(manage);
//
//        // FluencyTraining 저장
//        return fluencyTrainingRepository.save(fluencyTraining);
//    }
}
