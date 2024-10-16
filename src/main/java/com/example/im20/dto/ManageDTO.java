package com.example.im20.dto;

import com.example.im20.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManageDTO {

    private Integer manageId;
    private LocalDate manageDate;
    private Integer userId;

    private List<BreathingTrainingDTO> breathingTrainings;
    private List<FluencyTrainingDTO> fluencyTrainings;
    private List<PronunciationTrainingDTO> pronunciationTrainings;

    // Manage 엔티티로부터 DTO 변환
    public ManageDTO(Manage manage) {
        this.manageId = manage.getManageId();
        this.manageDate = manage.getManageDate();
        this.userId = manage.getUser().getUserId();

        // 훈련 리스트를 각각 DTO 리스트로 변환
        this.breathingTrainings = manage.getBreathingTrainings().stream().map(BreathingTrainingDTO::new).toList();
        this.fluencyTrainings = manage.getFluencyTrainings().stream().map(FluencyTrainingDTO::new).toList();
        this.pronunciationTrainings = manage.getPronunciationTrainings().stream().map(PronunciationTrainingDTO::new).toList();
    }
}
