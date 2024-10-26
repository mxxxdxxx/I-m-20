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

        // manageId 설정
        breathingTrainingDTO.setManageId(manageId);

        // BreathingTraining 요약과 세부 정보 저장
        BreathingTrainingDTO savedBreathingTraining = breathingTrainingService.saveBreathingTraining(breathingTrainingDTO);
        return ResponseEntity.ok(savedBreathingTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreathingTrainingDTO> getBreathingTrainingById(@PathVariable Integer id) {
        // ID로 BreathingTraining을 가져와 요약과 세부 정보 반환
        BreathingTrainingDTO breathingTraining = breathingTrainingService.getBreathingTrainingById(id);
        return ResponseEntity.ok(breathingTraining);
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
