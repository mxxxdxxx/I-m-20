package com.example.im20.controller;

import com.example.im20.dto.BreathingTrainingDTO;
import com.example.im20.service.BreathingTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings/bt")
public class BreathingTrainingController {

    @Autowired
    private BreathingTrainingService breathingTrainingService;

    @PostMapping
    public ResponseEntity<BreathingTrainingDTO> createBreathingTraining(@RequestBody BreathingTrainingDTO breathingTrainingDTO) {
        BreathingTrainingDTO createdBreathingTraining = breathingTrainingService.saveBreathingTraining(breathingTrainingDTO);
        return ResponseEntity.ok(createdBreathingTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreathingTrainingDTO> getBreathingTrainingById(@PathVariable Integer id) {
        Optional<BreathingTrainingDTO> breathingTraining = breathingTrainingService.getBreathingTrainingById(id);
        return breathingTraining.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BreathingTrainingDTO> updateBreathingTraining(@PathVariable Integer id, @RequestBody BreathingTrainingDTO breathingTrainingDTO) {
        BreathingTrainingDTO updatedBreathingTraining = breathingTrainingService.updateBreathingTraining(id, breathingTrainingDTO);
        return ResponseEntity.ok(updatedBreathingTraining);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBreathingTraining(@PathVariable Integer id) {
        breathingTrainingService.deleteBreathingTraining(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BreathingTrainingDTO>> getAllBreathingTrainings() {
        List<BreathingTrainingDTO> breathingTrainings = breathingTrainingService.getAllBreathingTrainings();
        return ResponseEntity.ok(breathingTrainings);
    }

}


//@RestController
//@RequestMapping("/trainings/bt")
//public class BreathingTrainingController {
//
//    @Autowired
//    private GameService gameService;
//
//    @Autowired
//    private ManageRepository manageRepository;
//
//    @Autowired
//    private BreathingTrainingRepository breathingTrainingRepository;
//
//    @PostMapping("/{manageId}")
//    public BreathingTraining saveBreathingTraining(@PathVariable Integer manageId, @RequestBody BreathingTrainingDTO breathingTrainingDTO) {
//        BreathingTraining breathingTraining = toEntity(breathingTrainingDTO);
//        return gameService.saveBreathingTraining(breathingTraining, manageId);
//    }
//
//    private BreathingTraining toEntity(BreathingTrainingDTO dto) {
//        return BreathingTraining.builder()
//                .breathingTrainingId(dto.getBtId())
//                .btFeedback(dto.getBtFeedback())
//                .btLength(dto.getBtLength())
//                .btLevel1(dto.getBtLevel1())
//                .btLevel2(dto.getBtLevel2())
//                .btLevel3(dto.getBtLevel3())
//                .btLevel4(dto.getBtLevel4())
//                .btLevel5(dto.getBtLevel5())
//                .btLevel6(dto.getBtLevel6())
//                .btSuccess(dto.getBtSuccess())
//                .btTimes(dto.getBtTimes())
//                .manage(Manage.builder().manageId(dto.getManageId()).build())
//                .build();
//    }
//
////    @PostMapping("/{manageId}")
////    public BreathingTraining saveBreathingTraining(@PathVariable Integer manageId, @RequestBody BreathingTraining breathingTraining) {
////        return gameService.saveBreathingTraining(breathingTraining, manageId);
////    }
//
////    @PostMapping("/{manageId}")
////    public BreathingTraining saveBreathingTraining(@PathVariable Integer manageId, @RequestBody BreathingTraining breathingTraining) throws IOException {
////        // Manage 엔티티 조회
////        Manage manage = manageRepository.findById(manageId)
////                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
////
////        // BreathingTraining 엔티티에 Manage 엔티티 설정
////        breathingTraining.setManage(manage);
////
////        // BreathingTraining 저장
////        return breathingTrainingRepository.save(breathingTraining);
////    }
//}
