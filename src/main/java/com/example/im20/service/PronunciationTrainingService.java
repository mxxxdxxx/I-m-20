package com.example.im20.service;

import com.example.im20.dto.PronunciationTrainingDTO;
import com.example.im20.dto.PronunciationTrainingDetailsDTO;
import com.example.im20.entity.PronunciationTraining;
import com.example.im20.entity.PronunciationTrainingDetails;
import com.example.im20.entity.Manage;
import com.example.im20.repository.PronunciationTrainingRepository;
import com.example.im20.repository.PronunciationTrainingDetailsRepository;
import com.example.im20.repository.ManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PronunciationTrainingService {

    @Autowired
    private PronunciationTrainingRepository pronunciationTrainingRepository;

    @Autowired
    private PronunciationTrainingDetailsRepository pronunciationTrainingDetailsRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public PronunciationTrainingDTO savePronunciationTraining(PronunciationTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        // PronunciationTraining 저장
        PronunciationTraining pronunciationTraining = toEntity(dto, manage);
        PronunciationTraining savedPronunciationTraining = pronunciationTrainingRepository.save(pronunciationTraining);

        // PronunciationTrainingDetails 저장
        List<PronunciationTrainingDetails> detailsList = dto.getDetails().stream()
                .map(detailDTO -> toDetailsEntity(detailDTO, savedPronunciationTraining))
                .collect(Collectors.toList());
        pronunciationTrainingDetailsRepository.saveAll(detailsList);

        return toDTO(savedPronunciationTraining, detailsList);
    }

    private PronunciationTraining toEntity(PronunciationTrainingDTO dto, Manage manage) {
        return PronunciationTraining.builder()
                .ptAttempt(dto.getPtAttempt())
                .ptSuccessCnt(dto.getPtSuccessCnt())
                .manage(manage)
                .build();
    }

    private PronunciationTrainingDetails toDetailsEntity(PronunciationTrainingDetailsDTO dto, PronunciationTraining pronunciationTraining) {
        return PronunciationTrainingDetails.builder()
                .pronunciationTraining(pronunciationTraining)
                .ptWord(dto.getPtWord())
                .ptText(dto.getPtText())
                .ptChildVoice(dto.getPtChildVoice())  // 인코딩된 데이터로 저장
                .ptTeacherVoice(dto.getPtTeacherVoice()) // 인코딩된 데이터로 저장
                .ptScore(dto.getPtScore())
                .ptFeedback(dto.getPtFeedback())
                .index(dto.getIndex())
                .build();
    }

    private PronunciationTrainingDTO toDTO(PronunciationTraining entity, List<PronunciationTrainingDetails> detailsList) {
        List<PronunciationTrainingDetailsDTO> detailsDTOs = detailsList.stream()
                .map(this::toDetailsDTO)
                .collect(Collectors.toList());

        return PronunciationTrainingDTO.builder()
                .pronunciationTrainingId(entity.getPronunciationTrainingId())
                .ptAttempt(entity.getPtAttempt())
                .ptSuccessCnt(entity.getPtSuccessCnt())
                .manageId(entity.getManage().getManageId())
                .details(detailsDTOs)
                .build();
    }

    private PronunciationTrainingDetailsDTO toDetailsDTO(PronunciationTrainingDetails entity) {
        return PronunciationTrainingDetailsDTO.builder()
                .detailId(entity.getDetailId())
                .ptWord(entity.getPtWord())
                .ptText(entity.getPtText())
                .ptChildVoice(entity.getPtChildVoice()) // 인코딩된 데이터를 그대로 사용
                .ptTeacherVoice(entity.getPtTeacherVoice()) // 인코딩된 데이터를 그대로 사용
                .ptScore(entity.getPtScore())
                .ptFeedback(entity.getPtFeedback())
                .index(entity.getIndex())
                .build();
    }

    @Transactional(readOnly = true)
    public PronunciationTrainingDTO getPronunciationTrainingById(Integer id) {
        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid PronunciationTraining ID"));

        // 해당 엔티티를 DTO로 변환하여 반환
        List<PronunciationTrainingDetails> detailsList = pronunciationTrainingDetailsRepository.findByPronunciationTraining(pronunciationTraining);
        return toDTO(pronunciationTraining, detailsList);
    }
}