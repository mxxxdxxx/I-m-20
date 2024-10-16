package com.example.im20.controller;

import com.example.im20.dto.FluencyTrainingDTO;
import com.example.im20.service.FluencyTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fluency-training")
public class FluencyTrainingController {

    @Autowired
    private FluencyTrainingService fluencyTrainingService;

    @PostMapping
    public ResponseEntity<FluencyTrainingDTO> createFluencyTraining(@RequestBody FluencyTrainingDTO fluencyTrainingDTO) {
        FluencyTrainingDTO createdFluencyTraining = fluencyTrainingService.saveFluencyTraining(fluencyTrainingDTO);
        return ResponseEntity.ok(createdFluencyTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FluencyTrainingDTO> getFluencyTrainingById(@PathVariable Integer id) {
        Optional<FluencyTrainingDTO> fluencyTraining = fluencyTrainingService.getFluencyTrainingById(id);
        return fluencyTraining.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FluencyTrainingDTO> updateFluencyTraining(@PathVariable Integer id, @RequestBody FluencyTrainingDTO fluencyTrainingDTO) {
        FluencyTrainingDTO updatedFluencyTraining = fluencyTrainingService.saveFluencyTraining(fluencyTrainingDTO);
        return ResponseEntity.ok(updatedFluencyTraining);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFluencyTraining(@PathVariable Integer id) {
        fluencyTrainingService.deleteFluencyTraining(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FluencyTrainingDTO>> getAllFluencyTrainings() {
        List<FluencyTrainingDTO> fluencyTrainings = fluencyTrainingService.getAllFluencyTrainings();
        return ResponseEntity.ok(fluencyTrainings);
    }
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

