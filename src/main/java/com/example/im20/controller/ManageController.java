package com.example.im20.controller;

import com.example.im20.entity.*;
import com.example.im20.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private ManageRepository manageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BreathingTrainingRepository breathingTrainingRepository;

    @Autowired
    private FluencyTrainingRepository fluencyTrainingRepository;

    @Autowired
    private PronunciationTrainingRepository pronunciationTrainingRepository;

    @PostMapping("/start")
    public Manage startTraining(@RequestParam Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 ID입니다."));

        Date today = new Date();

        // 오늘 날짜에 해당 사용자의 Manage 엔티티가 있는지 확인
        Optional<Manage> existingManage = manageRepository.findByUserIdAndManageDate(userId, today);
        if (existingManage.isPresent()) {
            return existingManage.get();
        }

        // 새로운 Manage 엔티티 생성 및 저장
        Manage manage = Manage.builder()
                .user(user)
                .manageDate(today)
                .build();
        return manageRepository.save(manage);
    }

    // 특정 Manage 엔티티에 포함된 모든 트레이닝 엔티티 조회
    @GetMapping("/{manageId}/trainings")
    public List<Object> getAllTrainings(@PathVariable Integer manageId) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));

        List<BreathingTraining> breathingTrainings = breathingTrainingRepository.findByManage(manage);
        List<FluencyTraining> fluencyTrainings = fluencyTrainingRepository.findByManage(manage);
        List<PronunciationTraining> pronunciationTrainings = pronunciationTrainingRepository.findByManage(manage);

        return List.of(breathingTrainings, fluencyTrainings, pronunciationTrainings);
    }

    // BreathingTraining 생성
    @PostMapping("/{manageId}/breathing-training")
    public BreathingTraining createBreathingTraining(@PathVariable Integer manageId, @RequestBody BreathingTraining breathingTraining) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
        breathingTraining.setManage(manage);
        return breathingTrainingRepository.save(breathingTraining);
    }

    // FluencyTraining 생성
    @PostMapping("/{manageId}/fluency-training")
    public FluencyTraining createFluencyTraining(@PathVariable Integer manageId, @RequestBody FluencyTraining fluencyTraining) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
        fluencyTraining.setManage(manage);
        return fluencyTrainingRepository.save(fluencyTraining);
    }

    // PronunciationTraining 생성
    @PostMapping("/{manageId}/pronunciation-training")
    public PronunciationTraining createPronunciationTraining(@PathVariable Integer manageId, @RequestBody PronunciationTraining pronunciationTraining) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Manage ID입니다."));
        pronunciationTraining.setManage(manage);
        return pronunciationTrainingRepository.save(pronunciationTraining);
    }

    // BreathingTraining 업데이트
    @PutMapping("/breathing-training/{id}")
    public BreathingTraining updateBreathingTraining(@PathVariable Integer id, @RequestBody BreathingTraining breathingTrainingDetails) {
        BreathingTraining breathingTraining = breathingTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 BreathingTraining ID입니다."));

        breathingTraining.setBtLength(breathingTrainingDetails.getBtLength());
        breathingTraining.setBtLevel1(breathingTrainingDetails.getBtLevel1());
        breathingTraining.setBtLevel2(breathingTrainingDetails.getBtLevel2());
        breathingTraining.setBtLevel3(breathingTrainingDetails.getBtLevel3());
        breathingTraining.setBtLevel4(breathingTrainingDetails.getBtLevel4());
        breathingTraining.setBtLevel5(breathingTrainingDetails.getBtLevel5());
        breathingTraining.setBtLevel6(breathingTrainingDetails.getBtLevel6());
        breathingTraining.setBtFeedback(breathingTrainingDetails.getBtFeedback());
        breathingTraining.setBtTimes(breathingTrainingDetails.getBtTimes());

        return breathingTrainingRepository.save(breathingTraining);
    }

    // FluencyTraining 업데이트
    @PutMapping("/fluency-training/{id}")
    public FluencyTraining updateFluencyTraining(@PathVariable Integer id, @RequestBody FluencyTraining fluencyTrainingDetails) {
        FluencyTraining fluencyTraining = fluencyTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 FluencyTraining ID입니다."));

        fluencyTraining.setFtFeedback(fluencyTrainingDetails.getFtFeedback());

        return fluencyTrainingRepository.save(fluencyTraining);
    }

    // PronunciationTraining 업데이트
    @PutMapping("/pronunciation-training/{id}")
    public PronunciationTraining updatePronunciationTraining(@PathVariable Integer id, @RequestBody PronunciationTraining pronunciationTrainingDetails) {
        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 PronunciationTraining ID입니다."));

        pronunciationTraining.setPtAccuracy(pronunciationTrainingDetails.getPtAccuracy());
        pronunciationTraining.setPtFeedback(pronunciationTrainingDetails.getPtFeedback());
        pronunciationTraining.setPtWords(pronunciationTrainingDetails.getPtWords());
        pronunciationTraining.setPtTimes(pronunciationTrainingDetails.getPtTimes());
        pronunciationTraining.setPtTeacher(pronunciationTrainingDetails.getPtTeacher());
        pronunciationTraining.setPtPic(pronunciationTrainingDetails.getPtPic());
        pronunciationTraining.setPtStdVoice(pronunciationTrainingDetails.getPtStdVoice());

        return pronunciationTrainingRepository.save(pronunciationTraining);
    }

    // BreathingTraining 삭제
    @DeleteMapping("/breathing-training/{id}")
    public void deleteBreathingTraining(@PathVariable Integer id) {
        BreathingTraining breathingTraining = breathingTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 BreathingTraining ID입니다."));
        breathingTrainingRepository.delete(breathingTraining);
    }

    // FluencyTraining 삭제
    @DeleteMapping("/fluency-training/{id}")
    public void deleteFluencyTraining(@PathVariable Integer id) {
        FluencyTraining fluencyTraining = fluencyTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 FluencyTraining ID입니다."));
        fluencyTrainingRepository.delete(fluencyTraining);
    }

    // PronunciationTraining 삭제
    @DeleteMapping("/pronunciation-training/{id}")
    public void deletePronunciationTraining(@PathVariable Integer id) {
        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 PronunciationTraining ID입니다."));
        pronunciationTrainingRepository.delete(pronunciationTraining);
    }
}
