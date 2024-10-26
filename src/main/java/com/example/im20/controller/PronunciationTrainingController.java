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
        PronunciationTrainingDTO pronunciationTraining = pronunciationTrainingService.getPronunciationTrainingById(id);
        return ResponseEntity.ok(pronunciationTraining);
    }
}
