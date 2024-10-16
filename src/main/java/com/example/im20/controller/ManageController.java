package com.example.im20.controller;

import com.example.im20.dto.ManageDTO;
import com.example.im20.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/manages")
public class ManageController {

    @Autowired
    private ManageService manageService;

    // 새로운 트레이닝 세션을 시작하는 API (해당 날짜 기준으로 새로운 세션 시작)
    @PostMapping("/start")
    public ResponseEntity<ManageDTO> startTraining(@RequestParam Integer userId) {
        LocalDate today = LocalDate.now();
        ManageDTO manageDTO = manageService.startTraining(userId, today); // 오늘 날짜 기준으로 시작
        return ResponseEntity.ok(manageDTO);
    }

    // 특정 날짜에 대한 Manage 엔티티에 포함된 모든 훈련 엔티티 조회
    @GetMapping("/{userId}/trainings")
    public ResponseEntity<ManageDTO> getAllTrainings(@PathVariable Integer userId, @RequestParam("date") String date) {
        LocalDate requestedDate = LocalDate.parse(date);
        ManageDTO manageDTO = manageService.getTrainingsForDate(userId, requestedDate); // 특정 날짜의 훈련 조회
        return ResponseEntity.ok(manageDTO);
    }
}

//@RestController
//@RequestMapping("/manages")
//public class ManageController {
//
//    @Autowired
//    private ManageRepository manageRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BreathingTrainingRepository breathingTrainingRepository;
//
//    @Autowired
//    private FluencyTrainingRepository fluencyTrainingRepository;
//
//    @Autowired
//    private PronunciationTrainingRepository pronunciationTrainingRepository;
//
//    @PostMapping("/start")
//    public Manage startTraining(@RequestParam Integer userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 ID입니다."));
//
////        Date today = new Date();
//        LocalDate today = LocalDate.now();
//
//        // 오늘 날짜에 해당 사용자의 Manage 엔티티가 있는지 확인
//        Optional<Manage> existingManage = manageRepository.findByUserIdAndManageDate(userId, today);
//        if (existingManage.isPresent()) {
//            return existingManage.get();
//        }
//
//        // 새로운 Manage 엔티티 생성 및 저장
//        Manage manage = Manage.builder()
//                .user(user)
//                .manageDate(today)
//                .build();
//        return manageRepository.save(manage);
//    }
//
//    // 특정 Manage 엔티티에 포함된 모든 트레이닝 엔티티 조회
//    @GetMapping("/{manageId}/trainings")
//    public ResponseEntity<Map<String, List<?>>> getAllTrainings(@PathVariable Integer manageId) {
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//
//        List<BreathingTraining> breathingTrainings = breathingTrainingRepository.findByManage(manage);
//        List<FluencyTraining> fluencyTrainings = fluencyTrainingRepository.findByManage(manage);
//        List<PronunciationTraining> pronunciationTrainings = pronunciationTrainingRepository.findByManage(manage);
//
//        Map<String, List<?>> trainings = new HashMap<>();
//        trainings.put("breathingTrainings", breathingTrainings);
//        trainings.put("fluencyTrainings", fluencyTrainings);
//        trainings.put("pronunciationTrainings", pronunciationTrainings);
//
//        return ResponseEntity.ok(trainings);
//    }
////    @GetMapping("/{manageId}/trainings")
////    public List<Object> getAllTrainings(@PathVariable Integer manageId) {
////        Manage manage = manageRepository.findById(manageId)
////                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
////
////        List<BreathingTraining> breathingTrainings = breathingTrainingRepository.findByManage(manage);
////        List<FluencyTraining> fluencyTrainings = fluencyTrainingRepository.findByManage(manage);
////        List<PronunciationTraining> pronunciationTrainings = pronunciationTrainingRepository.findByManage(manage);
////
////        return List.of(breathingTrainings, fluencyTrainings, pronunciationTrainings);
////    }
//
//    // BreathingTraining 생성
//    @PostMapping("/{manageId}/bt")
//    public ResponseEntity<BreathingTraining> createBreathingTraining(@PathVariable Integer manageId, @RequestBody BreathingTraining breathingTraining) {
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//        breathingTraining.setManage(manage);
//        return ResponseEntity.ok(breathingTrainingRepository.save(breathingTraining));
//    }
//
//    @PostMapping("/{manageId}/ft")
//    public ResponseEntity<FluencyTraining> createFluencyTraining(@PathVariable Integer manageId, @RequestBody FluencyTraining fluencyTraining) {
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//        fluencyTraining.setManage(manage);
//        return ResponseEntity.ok(fluencyTrainingRepository.save(fluencyTraining));
//    }
//
//    @PostMapping("/{manageId}/pt")
//    public ResponseEntity<PronunciationTraining> createPronunciationTraining(@PathVariable Integer manageId, @RequestBody PronunciationTraining pronunciationTraining) {
//        Manage manage = manageRepository.findById(manageId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
//        pronunciationTraining.setManage(manage);
//        return ResponseEntity.ok(pronunciationTrainingRepository.save(pronunciationTraining));
//    }
//
//    @PutMapping("/bt/{id}")
//    public ResponseEntity<BreathingTraining> updateBreathingTraining(@PathVariable Integer id, @RequestBody BreathingTraining breathingTrainingDetails) {
//        BreathingTraining breathingTraining = breathingTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 BreathingTraining ID입니다."));
//
//        breathingTraining.setBtLength(breathingTrainingDetails.getBtLength());
//        breathingTraining.setBtLevel1(breathingTrainingDetails.getBtLevel1());
//        breathingTraining.setBtLevel2(breathingTrainingDetails.getBtLevel2());
//        breathingTraining.setBtLevel3(breathingTrainingDetails.getBtLevel3());
//        breathingTraining.setBtLevel4(breathingTrainingDetails.getBtLevel4());
//        breathingTraining.setBtLevel5(breathingTrainingDetails.getBtLevel5());
//        breathingTraining.setBtLevel6(breathingTrainingDetails.getBtLevel6());
//        breathingTraining.setBtFeedback(breathingTrainingDetails.getBtFeedback());
//        breathingTraining.setBtTimes(breathingTrainingDetails.getBtTimes());
//
//        return ResponseEntity.ok(breathingTrainingRepository.save(breathingTraining));
//    }
//
//    @PutMapping("/ft/{id}")
//    public ResponseEntity<FluencyTraining> updateFluencyTraining(@PathVariable Integer id, @RequestBody FluencyTraining fluencyTrainingDetails) {
//        FluencyTraining fluencyTraining = fluencyTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 FluencyTraining ID입니다."));
//
//        fluencyTraining.setFtFeedback(fluencyTrainingDetails.getFtFeedback());
//
//        return ResponseEntity.ok(fluencyTrainingRepository.save(fluencyTraining));
//    }
//
//    @PutMapping("/pt/{id}")
//    public ResponseEntity<PronunciationTraining> updatePronunciationTraining(@PathVariable Integer id, @RequestBody PronunciationTraining pronunciationTrainingDetails) {
//        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 PronunciationTraining ID입니다."));
//
//        pronunciationTraining.setPtAccuracy(pronunciationTrainingDetails.getPtAccuracy());
//        pronunciationTraining.setPtFeedback(pronunciationTrainingDetails.getPtFeedback());
//        pronunciationTraining.setPtWords(pronunciationTrainingDetails.getPtWords());
//        pronunciationTraining.setPtTimes(pronunciationTrainingDetails.getPtTimes());
//        pronunciationTraining.setPtTeacher(pronunciationTrainingDetails.getPtTeacher());
//        pronunciationTraining.setPtPic(pronunciationTrainingDetails.getPtPic());
//        pronunciationTraining.setPtStdVoice(pronunciationTrainingDetails.getPtStdVoice());
//
//        return ResponseEntity.ok(pronunciationTrainingRepository.save(pronunciationTraining));
//    }
//
//    @DeleteMapping("/bt/{id}")
//    public ResponseEntity<Void> deleteBreathingTraining(@PathVariable Integer id) {
//        BreathingTraining breathingTraining = breathingTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 BreathingTraining ID입니다."));
//        breathingTrainingRepository.delete(breathingTraining);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/ft/{id}")
//    public ResponseEntity<Void> deleteFluencyTraining(@PathVariable Integer id) {
//        FluencyTraining fluencyTraining = fluencyTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 FluencyTraining ID입니다."));
//        fluencyTrainingRepository.delete(fluencyTraining);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/pt/{id}")
//    public ResponseEntity<Void> deletePronunciationTraining(@PathVariable Integer id) {
//        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 PronunciationTraining ID입니다."));
//        pronunciationTrainingRepository.delete(pronunciationTraining);
//        return ResponseEntity.noContent().build();
//    }
//}