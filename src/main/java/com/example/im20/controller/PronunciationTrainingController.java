package com.example.im20.controller;

import com.example.im20.dto.PronunciationTrainingDTO;
import com.example.im20.service.PronunciationTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings/pt")
public class PronunciationTrainingController {

    @Autowired
    private PronunciationTrainingService pronunciationTrainingService;

    @PostMapping("/{manageId}")
    public ResponseEntity<PronunciationTrainingDTO> savePronunciationTraining(
            @PathVariable Integer manageId,
            @RequestBody PronunciationTrainingDTO pronunciationTrainingDTO) {

        pronunciationTrainingDTO.setManageId(manageId);
        PronunciationTrainingDTO savedPronunciationTraining = pronunciationTrainingService.savePronunciationTraining(pronunciationTrainingDTO);
        return ResponseEntity.ok(savedPronunciationTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PronunciationTrainingDTO> getPronunciationTrainingById(@PathVariable Integer id) {
        // PronunciationTrainingDTO를 가져오는 메서드를 추가하세요
        PronunciationTrainingDTO pronunciationTraining = pronunciationTrainingService.getPronunciationTrainingById(id);

        // 오디오 데이터는 Base64로 디코딩할 필요가 없습니다. 그냥 전송할 수 있습니다.
        return ResponseEntity.ok(pronunciationTraining);
    }
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

