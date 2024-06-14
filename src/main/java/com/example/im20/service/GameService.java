package com.example.im20.service;

import com.example.im20.dto.BreathingTrainingDTO;
import com.example.im20.dto.FluencyTrainingDTO;
import com.example.im20.dto.PronunciationTrainingDTO;
import com.example.im20.entity.BreathingTraining;
import com.example.im20.entity.FluencyTraining;
import com.example.im20.entity.Manage;
import com.example.im20.entity.PronunciationTraining;
import com.example.im20.repository.BreathingTrainingRepository;
import com.example.im20.repository.FluencyTrainingRepository;
import com.example.im20.repository.ManageRepository;
import com.example.im20.repository.PronunciationTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private BreathingTrainingRepository breathingTrainingRepository;

    @Autowired
    private FluencyTrainingRepository fluencyTrainingRepository;

    @Autowired
    private PronunciationTrainingRepository pronunciationTrainingRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public BreathingTraining saveBreathingTraining(BreathingTraining breathingTraining, Integer manageId) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        breathingTraining.setManage(manage);
        return breathingTrainingRepository.save(breathingTraining);
    }

    @Transactional
    public BreathingTrainingDTO saveBreathingTraining(BreathingTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        BreathingTraining breathingTraining = toEntity(dto, manage);
        BreathingTraining saved = breathingTrainingRepository.save(breathingTraining);
        return toDTO(saved);
    }

    @Transactional
    public FluencyTraining saveFluencyTraining(FluencyTraining fluencyTraining, Integer manageId) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        fluencyTraining.setManage(manage);
        return fluencyTrainingRepository.save(fluencyTraining);
    }

    @Transactional
    public FluencyTrainingDTO saveFluencyTraining(FluencyTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        FluencyTraining fluencyTraining = toEntity(dto, manage);
        FluencyTraining saved = fluencyTrainingRepository.save(fluencyTraining);
        return toDTO(saved);
    }

    @Transactional
    public PronunciationTraining savePronunciationTraining(PronunciationTraining pronunciationTraining, Integer manageId) {
        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        pronunciationTraining.setManage(manage);
        return pronunciationTrainingRepository.save(pronunciationTraining);
    }

    @Transactional
    public PronunciationTrainingDTO savePronunciationTraining(PronunciationTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
        PronunciationTraining pronunciationTraining = toEntity(dto, manage);
        PronunciationTraining saved = pronunciationTrainingRepository.save(pronunciationTraining);
        return toDTO(saved);
    }

    private BreathingTraining toEntity(BreathingTrainingDTO dto, Manage manage) {
        return BreathingTraining.builder()
                .breathingTrainingId(dto.getBtId())
                .btFeedback(dto.getBtFeedback())
                .btLength(dto.getBtLength())
                .btLevel1(dto.getBtLevel1())
                .btLevel2(dto.getBtLevel2())
                .btLevel3(dto.getBtLevel3())
                .btLevel4(dto.getBtLevel4())
                .btLevel5(dto.getBtLevel5())
                .btLevel6(dto.getBtLevel6())
                .btSuccess(dto.getBtSuccess())
                .btTimes(dto.getBtTimes())
                .manage(manage)
                .build();
    }

    private BreathingTrainingDTO toDTO(BreathingTraining entity) {
        return BreathingTrainingDTO.builder()
                .btId(entity.getBreathingTrainingId())
                .btFeedback(entity.getBtFeedback())
                .btLength(entity.getBtLength())
                .btLevel1(entity.getBtLevel1())
                .btLevel2(entity.getBtLevel2())
                .btLevel3(entity.getBtLevel3())
                .btLevel4(entity.getBtLevel4())
                .btLevel5(entity.getBtLevel5())
                .btLevel6(entity.getBtLevel6())
                .btSuccess(entity.getBtSuccess())
                .btTimes(entity.getBtTimes())
                .manageId(entity.getManage().getManageId())
                .build();
    }

    private FluencyTraining toEntity(FluencyTrainingDTO dto, Manage manage) {
        return FluencyTraining.builder()
                .fluencyTrainingId(dto.getFtId())
                .ftFeedback(dto.getFtFeedback())
                .manage(manage)
                .build();
    }

    private FluencyTrainingDTO toDTO(FluencyTraining entity) {
        return FluencyTrainingDTO.builder()
                .ftId(entity.getFluencyTrainingId())
                .ftFeedback(entity.getFtFeedback())
                .manageId(entity.getManage().getManageId())
                .build();
    }

    private PronunciationTraining toEntity(PronunciationTrainingDTO dto, Manage manage) {
        return PronunciationTraining.builder()
                .pronunciationTrainingId(dto.getPtId())
                .ptAccuracy(dto.getPtAccuracy())
                .ptFeedback(dto.getPtFeedback())
                .ptWords(dto.getPtWords())
                .ptTimes(dto.getPtTimes())
                .ptTeacher(dto.getPtTeacher())
                .ptPic(dto.getPtPic())
                .ptStdVoice(dto.getPtStdVoice())
                .manage(manage)
                .build();
    }

    private PronunciationTrainingDTO toDTO(PronunciationTraining entity) {
        return PronunciationTrainingDTO.builder()
                .ptId(entity.getPronunciationTrainingId())
                .ptAccuracy(entity.getPtAccuracy())
                .ptFeedback(entity.getPtFeedback())
                .ptWords(entity.getPtWords())
                .ptTimes(entity.getPtTimes())
                .ptTeacher(entity.getPtTeacher())
                .ptPic(entity.getPtPic())
                .ptStdVoice(entity.getPtStdVoice())
                .manageId(entity.getManage().getManageId())
                .build();
    }
}
