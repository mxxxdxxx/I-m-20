package com.example.im20.controller;

import com.example.im20.dto.PronunciationTrainingDTO;
import com.example.im20.entity.Manage;
import com.example.im20.entity.PronunciationTraining;
import com.example.im20.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings/pt")
public class PronunciationTrainingController {

    @Autowired
    private GameService gameService;

    @PostMapping("/{manageId}")
    public PronunciationTraining savePronunciationTraining(@PathVariable Integer manageId, @RequestBody PronunciationTrainingDTO pronunciationTrainingDTO) {
        PronunciationTraining pronunciationTraining = toEntity(pronunciationTrainingDTO);
        return gameService.savePronunciationTraining(pronunciationTraining, manageId);
    }

    private PronunciationTraining toEntity(PronunciationTrainingDTO dto) {
        return PronunciationTraining.builder()
                .pronunciationTrainingId(dto.getPtId())
                .ptAccuracy(dto.getPtAccuracy())
                .ptFeedback(dto.getPtFeedback())
                .ptWords(dto.getPtWords())
                .ptTimes(dto.getPtTimes())
                .ptTeacher(dto.getPtTeacher())
                .ptPic(dto.getPtPic())
                .ptStdVoice(dto.getPtStdVoice())
                .manage(Manage.builder().manageId(dto.getManageId()).build())
                .build();
    }

//    @PostMapping("/{manageId}")
//    public PronunciationTraining savePronunciationTraining(@PathVariable Integer manageId, @RequestBody PronunciationTraining pronunciationTraining) {
//        return gameService.savePronunciationTraining(pronunciationTraining, manageId);
//    }


//    @PostMapping("/{manageId}")
//    public PronunciationTraining savePronunciationTraining(@PathVariable Integer manageId, @RequestBody PronunciationTraining pronunciationTraining) {
//        // Manage 엔티티 조회
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//
//        // PronunciationTraining 엔티티에 Manage 엔티티 설정
//        pronunciationTraining.setManage(manage);
//
//        // PronunciationTraining 저장
//        return pronunciationTrainingRepository.save(pronunciationTraining);
//    }
}
