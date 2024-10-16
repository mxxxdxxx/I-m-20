package com.example.im20.dto;

import com.example.im20.entity.BreathingTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreathingTrainingDTO {

    private Integer breathingTrainingId;
    private Float btLength;
    private Float btLevel1;
    private Float btLevel2;
    private Float btLevel3;
    private Float btLevel4;
    private Float btLevel5;
    private Float btLevel6;
    private Integer btTimes;
    private Integer btSuccessCnt;
    private Integer manageId;

    // Manage 엔티티에서 생성자를 추가해야 한다면 여기에 생성
    public BreathingTrainingDTO(BreathingTraining entity) {
        this.breathingTrainingId = entity.getBreathingTrainingId();
        this.btLength = entity.getBtLength();
        this.btLevel1 = entity.getBtLevel1();
        this.btLevel2 = entity.getBtLevel2();
        this.btLevel3 = entity.getBtLevel3();
        this.btLevel4 = entity.getBtLevel4();
        this.btLevel5 = entity.getBtLevel5();
        this.btLevel6 = entity.getBtLevel6();
        this.btTimes = entity.getBtTimes();
        this.btSuccessCnt = entity.getBtSuccessCnt();
        this.manageId = entity.getManage().getManageId();
    }

    // Getters and Setters
    public Integer getBreathingTrainingId() {
        return breathingTrainingId;
    }

    public void setBreathingTrainingId(Integer breathingTrainingId) {
        this.breathingTrainingId = breathingTrainingId;
    }

    public Float getBtLength() {
        return btLength;
    }

    public void setBtLength(Float btLength) {
        this.btLength = btLength;
    }

    public Float getBtLevel1() {
        return btLevel1;
    }

    public void setBtLevel1(Float btLevel1) {
        this.btLevel1 = btLevel1;
    }

    public Float getBtLevel2() {
        return btLevel2;
    }

    public void setBtLevel2(Float btLevel2) {
        this.btLevel2 = btLevel2;
    }

    public Float getBtLevel3() {
        return btLevel3;
    }

    public void setBtLevel3(Float btLevel3) {
        this.btLevel3 = btLevel3;
    }

    public Float getBtLevel4() {
        return btLevel4;
    }

    public void setBtLevel4(Float btLevel4) {
        this.btLevel4 = btLevel4;
    }

    public Float getBtLevel5() {
        return btLevel5;
    }

    public void setBtLevel5(Float btLevel5) {
        this.btLevel5 = btLevel5;
    }

    public Float getBtLevel6() {
        return btLevel6;
    }

    public void setBtLevel6(Float btLevel6) {
        this.btLevel6 = btLevel6;
    }

    public Integer getBtTimes() {
        return btTimes;
    }

    public void setBtTimes(Integer btTimes) {
        this.btTimes = btTimes;
    }

    public Integer getBtSuccessCnt() {
        return btSuccessCnt;
    }

    public void setBtSuccessCnt(Integer btSuccessCnt) {
        this.btSuccessCnt = btSuccessCnt;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
