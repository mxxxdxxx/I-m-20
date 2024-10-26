package com.example.im20.dto;

import com.example.im20.entity.BreathingTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreathingTrainingDTO {

    private Integer breathingTrainingId; // ID 필드 추가
    private Integer manageId;
    private Integer totalBreaths;
    private Float averageLength;
    private Integer totalSuccessCnt;
    private List<BreathingTrainingDetailsDTO> details;

    public BreathingTrainingDTO(BreathingTraining entity) {
        this.breathingTrainingId = entity.getBreathingTrainingId();
        this.manageId = entity.getManage().getManageId();
        this.totalBreaths = entity.getTotalBreaths();
        this.averageLength = entity.getAverageLength();
        this.totalSuccessCnt = entity.getTotalSuccessCnt();
        this.details = entity.getDetails().stream().map(BreathingTrainingDetailsDTO::new).toList();
    }
}
