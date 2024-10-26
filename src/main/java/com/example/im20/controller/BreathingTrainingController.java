package com.example.im20.controller;

import com.example.im20.dto.BreathingTrainingDTO;
import com.example.im20.service.BreathingTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings/bt")
public class BreathingTrainingController {

    @Autowired
    private BreathingTrainingService breathingTrainingService;

    @PostMapping("/{manageId}")
    public ResponseEntity<BreathingTrainingDTO> saveBreathingTraining(
            @PathVariable Integer manageId,
            @RequestBody BreathingTrainingDTO breathingTrainingDTO) {

        breathingTrainingDTO.setManageId(manageId);
        BreathingTrainingDTO savedBreathingTraining = breathingTrainingService.saveBreathingTraining(breathingTrainingDTO);
        return ResponseEntity.ok(savedBreathingTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreathingTrainingDTO> getBreathingTrainingById(@PathVariable Integer id) {
        BreathingTrainingDTO breathingTraining = breathingTrainingService.getBreathingTrainingById(id);
        return ResponseEntity.ok(breathingTraining);
    }
}
