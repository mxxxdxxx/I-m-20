package com.example.im20.dto;

import com.example.im20.entity.FluencyTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluencyTrainingDTO {

    private Integer fluencyTrainingId;
    private Integer manageId;

    // Getters and Setters
    public Integer getFluencyTrainingId() {
        return fluencyTrainingId;
    }

    public FluencyTrainingDTO(FluencyTraining entity) {
        this.fluencyTrainingId = entity.getFluencyTrainingId();
        this.manageId = entity.getManage().getManageId();
    }

    public void setFluencyTrainingId(Integer fluencyTrainingId) {
        this.fluencyTrainingId = fluencyTrainingId;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
