package com.example.im20.service;

import com.example.im20.dto.BreathingTrainingDTO;
import com.example.im20.entity.BreathingTraining;
import com.example.im20.entity.Manage;
import com.example.im20.repository.BreathingTrainingRepository;
import com.example.im20.repository.ManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BreathingTrainingService {

    @Autowired
    private BreathingTrainingRepository breathingTrainingRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public BreathingTrainingDTO saveBreathingTraining(BreathingTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        BreathingTraining breathingTraining = toEntity(dto, manage);
        BreathingTraining saved = breathingTrainingRepository.save(breathingTraining);

        return toDTO(saved);
    }

    @Transactional
    public BreathingTrainingDTO updateBreathingTraining(Integer id, BreathingTrainingDTO dto) {
        BreathingTraining existingBreathingTraining = breathingTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BreathingTraining with ID " + id + " not found"));

        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        existingBreathingTraining.setBtLength(dto.getBtLength());
        existingBreathingTraining.setBtLevel1(dto.getBtLevel1());
        existingBreathingTraining.setBtLevel2(dto.getBtLevel2());
        existingBreathingTraining.setBtLevel3(dto.getBtLevel3());
        existingBreathingTraining.setBtLevel4(dto.getBtLevel4());
        existingBreathingTraining.setBtLevel5(dto.getBtLevel5());
        existingBreathingTraining.setBtLevel6(dto.getBtLevel6());
        existingBreathingTraining.setBtTimes(dto.getBtTimes());
        existingBreathingTraining.setBtSuccessCnt(dto.getBtSuccessCnt());
        existingBreathingTraining.setManage(manage);

        BreathingTraining updated = breathingTrainingRepository.save(existingBreathingTraining);
        return toDTO(updated);
    }

    @Transactional
    public void deleteBreathingTraining(Integer id) {
        breathingTrainingRepository.deleteById(id);
    }

    public List<BreathingTrainingDTO> getAllBreathingTrainings() {
        return breathingTrainingRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<BreathingTrainingDTO> getBreathingTrainingById(Integer id) {
        return breathingTrainingRepository.findById(id).map(this::toDTO);
    }

    private BreathingTraining toEntity(BreathingTrainingDTO dto, Manage manage) {
        return BreathingTraining.builder()
                .btLength(dto.getBtLength())
                .btLevel1(dto.getBtLevel1())
                .btLevel2(dto.getBtLevel2())
                .btLevel3(dto.getBtLevel3())
                .btLevel4(dto.getBtLevel4())
                .btLevel5(dto.getBtLevel5())
                .btLevel6(dto.getBtLevel6())
                .btTimes(dto.getBtTimes())
                .btSuccessCnt(dto.getBtSuccessCnt())
                .manage(manage)
                .build();
    }

    private BreathingTrainingDTO toDTO(BreathingTraining entity) {
        return BreathingTrainingDTO.builder()
                .btLength(entity.getBtLength())
                .btLevel1(entity.getBtLevel1())
                .btLevel2(entity.getBtLevel2())
                .btLevel3(entity.getBtLevel3())
                .btLevel4(entity.getBtLevel4())
                .btLevel5(entity.getBtLevel5())
                .btLevel6(entity.getBtLevel6())
                .btTimes(entity.getBtTimes())
                .btSuccessCnt(entity.getBtSuccessCnt())
                .manageId(entity.getManage().getManageId())
                .build();
    }
}
