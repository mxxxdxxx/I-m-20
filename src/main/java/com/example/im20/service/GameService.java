//package com.example.im20.service;
//
//import com.example.im20.dto.BreathingTrainingDTO;
//import com.example.im20.dto.FluencyTrainingDTO;
//import com.example.im20.dto.PronunciationTrainingDTO;
//import com.example.im20.entity.BreathingTraining;
//import com.example.im20.entity.FluencyTraining;
//import com.example.im20.entity.Manage;
//import com.example.im20.entity.PronunciationTraining;
//import com.example.im20.repository.BreathingTrainingRepository;
//import com.example.im20.repository.FluencyTrainingRepository;
//import com.example.im20.repository.ManageRepository;
//import com.example.im20.repository.PronunciationTrainingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class GameService {
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
//    @Autowired
//    private ManageRepository manageRepository;
//
//    @Transactional
//    public BreathingTrainingDTO saveBreathingTraining(BreathingTrainingDTO dto) {
//        Manage manage = manageRepository.findById(dto.getManageId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
//
//        // DTO를 엔티티로 변환하고 저장
//        BreathingTraining breathingTraining = toEntity(dto, manage);
//        BreathingTraining saved = breathingTrainingRepository.save(breathingTraining);
//
//        return toDTO(saved);
//    }
//
//    @Transactional
//    public FluencyTrainingDTO saveFluencyTraining(FluencyTrainingDTO dto) {
//        Manage manage = manageRepository.findById(dto.getManageId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
//
//        // DTO를 엔티티로 변환하고 저장
//        FluencyTraining fluencyTraining = toEntity(dto, manage);
//        FluencyTraining saved = fluencyTrainingRepository.save(fluencyTraining);
//
//        return toDTO(saved);
//    }
//
//    @Transactional
//    public PronunciationTrainingDTO savePronunciationTraining(PronunciationTrainingDTO dto) {
//        Manage manage = manageRepository.findById(dto.getManageId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
//
//        // DTO를 엔티티로 변환하고 저장
//        PronunciationTraining pronunciationTraining = toEntity(dto, manage);
//        PronunciationTraining saved = pronunciationTrainingRepository.save(pronunciationTraining);
//
//        return toDTO(saved);
//    }
//
//    // BreathingTraining 변환 메소드
//    private BreathingTraining toEntity(BreathingTrainingDTO dto, Manage manage) {
//        return BreathingTraining.builder()
//                .breathingTrainingId(dto.getBtId())
//                .btLength(dto.getBtLength())
//                .btLevel1(dto.getBtLevel1())
//                .btLevel2(dto.getBtLevel2())
//                .btLevel3(dto.getBtLevel3())
//                .btLevel4(dto.getBtLevel4())
//                .btLevel5(dto.getBtLevel5())
//                .btLevel6(dto.getBtLevel6())
//                .btSuccess(dto.getBtSuccess())
//                .btTimes(dto.getBtTimes())
//                .manage(manage)
//                .build();
//    }
//
//    private BreathingTrainingDTO toDTO(BreathingTraining entity) {
//        return BreathingTrainingDTO.builder()
//                .btId(entity.getBreathingTrainingId())
//                .btLength(entity.getBtLength())
//                .btLevel1(entity.getBtLevel1())
//                .btLevel2(entity.getBtLevel2())
//                .btLevel3(entity.getBtLevel3())
//                .btLevel4(entity.getBtLevel4())
//                .btLevel5(entity.getBtLevel5())
//                .btLevel6(entity.getBtLevel6())
//                .btSuccess(entity.getBtSuccess())
//                .btTimes(entity.getBtTimes())
//                .manageId(entity.getManage().getManageId())
//                .build();
//    }
//
//    // FluencyTraining 변환 메소드
//    private FluencyTraining toEntity(FluencyTrainingDTO dto, Manage manage) {
//        return FluencyTraining.builder()
//                .fluencyTrainingId(dto.getFtId())
//                .manage(manage)
//                .build();
//    }
//
//    private FluencyTrainingDTO toDTO(FluencyTraining entity) {
//        return FluencyTrainingDTO.builder()
//                .ftId(entity.getFluencyTrainingId())
//                .manageId(entity.getManage().getManageId())
//                .build();
//    }
//
//    // PronunciationTraining 변환 메소드
//    private PronunciationTraining toEntity(PronunciationTrainingDTO dto, Manage manage) {
//        return PronunciationTraining.builder()
//                .pronunciationTrainingId(dto.getPtId())
//                .ptWords(dto.getPtWords())
//                .ptTeacherVoice(dto.getPtTeacherVoice())
//                .ptChildVoice(dto.getPtChildVoice())
//                .ptScore(dto.getPtScore())
//                .ptAttempt(dto.getPtAttempt())
//                .ptSuccess(dto.getPtSuccess())
//                .manage(manage)
//                .build();
//    }
//
//    private PronunciationTrainingDTO toDTO(PronunciationTraining entity) {
//        return PronunciationTrainingDTO.builder()
//                .ptId(entity.getPronunciationTrainingId())
//                .ptWords(entity.getPtWords())
//                .ptTeacherVoice(entity.getPtTeacherVoice())
//                .ptChildVoice(entity.getPtChildVoice())
//                .ptScore(entity.getPtScore())
//                .ptAttempt(entity.getPtAttempt())
//                .ptSuccess(entity.getPtSuccess())
//                .manageId(entity.getManage().getManageId())
//                .build();
//    }
//}
