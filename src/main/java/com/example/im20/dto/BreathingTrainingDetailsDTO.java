package com.example.im20.dto;

import com.example.im20.entity.BreathingTrainingDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreathingTrainingDetailsDTO {

    private Integer btDetailId;
    private Integer btSummaryId;
    private Float btLength;
    private Float btLevel1;
    private Float btLevel2;
    private Float btLevel3;
    private Float btLevel4;
    private Float btLevel5;
    private Float btLevel6;
    private Integer btSuccessCnt;

    public BreathingTrainingDetailsDTO(BreathingTrainingDetails entity) {
        this.btDetailId = entity.getBtDetailId();
        this.btSummaryId = entity.getBtSummary().getBreathingTrainingId();
        this.btLength = entity.getBtLength();
        this.btLevel1 = entity.getBtLevel1();
        this.btLevel2 = entity.getBtLevel2();
        this.btLevel3 = entity.getBtLevel3();
        this.btLevel4 = entity.getBtLevel4();
        this.btLevel5 = entity.getBtLevel5();
        this.btLevel6 = entity.getBtLevel6();
        this.btSuccessCnt = entity.getBtSuccessCnt();
    }
}
