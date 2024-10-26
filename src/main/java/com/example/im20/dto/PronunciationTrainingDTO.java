package com.example.im20.dto;

import com.example.im20.entity.PronunciationTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PronunciationTrainingDTO {

    private Integer pronunciationTrainingId;
    private Integer ptAttempt;
    private Boolean ptSuccessCnt;
    private Integer manageId;
    private List<PronunciationTrainingDetailsDTO> details;

    public PronunciationTrainingDTO(PronunciationTraining entity) {
        this.pronunciationTrainingId = entity.getPronunciationTrainingId();
        this.ptAttempt = entity.getPtAttempt();
        this.ptSuccessCnt = entity.getPtSuccessCnt();
        this.manageId = entity.getManage().getManageId();
        this.details = entity.getDetails().stream().map(PronunciationTrainingDetailsDTO::new).toList();
    }

    // Getters and Setters
    public Integer getPronunciationTrainingId() {
        return pronunciationTrainingId;
    }

    public void setPronunciationTrainingId(Integer pronunciationTrainingId) {
        this.pronunciationTrainingId = pronunciationTrainingId;
    }

    public Integer getPtAttempt() {
        return ptAttempt;
    }

    public void setPtAttempt(Integer ptAttempt) {
        this.ptAttempt = ptAttempt;
    }

    public Boolean getPtSuccessCnt() {
        return ptSuccessCnt;
    }

    public void setPtSuccessCnt(Boolean ptSuccessCnt) {
        this.ptSuccessCnt = ptSuccessCnt;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    public List<PronunciationTrainingDetailsDTO> getDetails() {
        return details;
    }

    public void setDetails(List<PronunciationTrainingDetailsDTO> details) {
        this.details = details;
    }
}
