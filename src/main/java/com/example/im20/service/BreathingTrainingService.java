package com.example.im20.service;

import com.example.im20.dto.BreathingTrainingDTO;
import com.example.im20.dto.BreathingTrainingDetailsDTO;
import com.example.im20.entity.BreathingTraining;
import com.example.im20.entity.BreathingTrainingDetails;
import com.example.im20.entity.Manage;
import com.example.im20.repository.BreathingTrainingDetailsRepository;
import com.example.im20.repository.BreathingTrainingRepository;
import com.example.im20.repository.ManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreathingTrainingService {

    @Autowired
    private BreathingTrainingRepository breathingTrainingRepository;

    @Autowired
    private BreathingTrainingDetailsRepository breathingTrainingDetailsRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public BreathingTrainingDTO saveBreathingTraining(BreathingTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        BreathingTraining breathingTraining = toEntity(dto, manage);
        BreathingTraining savedBreathingTraining = breathingTrainingRepository.save(breathingTraining);

        List<BreathingTrainingDetails> detailsList = dto.getDetails().stream()
                .map(detailDTO -> toDetailsEntity(detailDTO, savedBreathingTraining))
                .collect(Collectors.toList());
        breathingTrainingDetailsRepository.saveAll(detailsList);

        return toDTO(savedBreathingTraining, detailsList);
    }

    private BreathingTraining toEntity(BreathingTrainingDTO dto, Manage manage) {
        return BreathingTraining.builder()
                .manage(manage)
                .totalBreaths(dto.getTotalBreaths())
                .averageLength(dto.getAverageLength())
                .totalSuccessCnt(dto.getTotalSuccessCnt())
                .build();
    }

    private BreathingTrainingDetails toDetailsEntity(BreathingTrainingDetailsDTO dto, BreathingTraining summary) {
        return BreathingTrainingDetails.builder()
                .btSummary(summary)
                .btLength(dto.getBtLength())
                .btLevel1(dto.getBtLevel1())
                .btLevel2(dto.getBtLevel2())
                .btLevel3(dto.getBtLevel3())
                .btLevel4(dto.getBtLevel4())
                .btLevel5(dto.getBtLevel5())
                .btLevel6(dto.getBtLevel6())
                .btSuccessCnt(dto.getBtSuccessCnt())
                .build();
    }

    private BreathingTrainingDTO toDTO(BreathingTraining entity, List<BreathingTrainingDetails> detailsList) {
        List<BreathingTrainingDetailsDTO> detailsDTOs = detailsList.stream()
                .map(this::toDetailsDTO)
                .collect(Collectors.toList());

        return BreathingTrainingDTO.builder()
                .breathingTrainingId(entity.getBreathingTrainingId())
                .manageId(entity.getManage().getManageId())
                .totalBreaths(entity.getTotalBreaths())
                .averageLength(entity.getAverageLength())
                .totalSuccessCnt(entity.getTotalSuccessCnt())
                .details(detailsDTOs)
                .build();
    }

    private BreathingTrainingDetailsDTO toDetailsDTO(BreathingTrainingDetails entity) {
        return BreathingTrainingDetailsDTO.builder()
                .btDetailId(entity.getBtDetailId())
                .btSummaryId(entity.getBtSummary().getBreathingTrainingId())
                .btLength(entity.getBtLength())
                .btLevel1(entity.getBtLevel1())
                .btLevel2(entity.getBtLevel2())
                .btLevel3(entity.getBtLevel3())
                .btLevel4(entity.getBtLevel4())
                .btLevel5(entity.getBtLevel5())
                .btLevel6(entity.getBtLevel6())
                .btSuccessCnt(entity.getBtSuccessCnt())
                .build();
    }

    @Transactional(readOnly = true)
    public BreathingTrainingDTO getBreathingTrainingById(Integer id) {
        BreathingTraining breathingTraining = breathingTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid BreathingTraining ID"));

        List<BreathingTrainingDetails> detailsList = breathingTrainingDetailsRepository.findByBtSummary(breathingTraining);
        return toDTO(breathingTraining, detailsList);
    }
}
