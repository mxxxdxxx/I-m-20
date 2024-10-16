package com.example.im20.service;

import com.example.im20.dto.FluencyTrainingDTO;
import com.example.im20.entity.FluencyTraining;
import com.example.im20.entity.Manage;
import com.example.im20.repository.FluencyTrainingRepository;
import com.example.im20.repository.ManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FluencyTrainingService {

    @Autowired
    private FluencyTrainingRepository fluencyTrainingRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public FluencyTrainingDTO saveFluencyTraining(FluencyTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        FluencyTraining fluencyTraining = toEntity(dto, manage);
        FluencyTraining saved = fluencyTrainingRepository.save(fluencyTraining);

        return toDTO(saved);
    }

    @Transactional
    public FluencyTrainingDTO updateFluencyTraining(Integer id, FluencyTrainingDTO dto) {
        FluencyTraining existingFluencyTraining = fluencyTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FluencyTraining with ID " + id + " not found"));

        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        // 업데이트할 필드 설정
        existingFluencyTraining.setManage(manage);

        FluencyTraining updated = fluencyTrainingRepository.save(existingFluencyTraining);
        return toDTO(updated);
    }

    @Transactional
    public void deleteFluencyTraining(Integer id) {
        fluencyTrainingRepository.deleteById(id);
    }

    public List<FluencyTrainingDTO> getAllFluencyTrainings() {
        return fluencyTrainingRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<FluencyTrainingDTO> getFluencyTrainingById(Integer id) {
        return fluencyTrainingRepository.findById(id).map(this::toDTO);
    }

    private FluencyTraining toEntity(FluencyTrainingDTO dto, Manage manage) {
        return FluencyTraining.builder()
                .manage(manage)
                .build();
    }

    private FluencyTrainingDTO toDTO(FluencyTraining entity) {
        return FluencyTrainingDTO.builder()
                .manageId(entity.getManage().getManageId())
                .build();
    }
}
