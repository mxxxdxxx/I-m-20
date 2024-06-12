package im20.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreathingTrainingDTO {
    private Integer btId;
    private String btFeedback;
    private float btLength;
    private float btLevel1;
    private float btLevel2;
    private float btLevel3;
    private float btLevel4;
    private float btLevel5;
    private float btLevel6;
    private Integer btSuccess;
    private Integer btTimes;
    private Integer manageId;

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getBtFeedback() {
        return btFeedback;
    }

    public void setBtFeedback(String btFeedback) {
        this.btFeedback = btFeedback;
    }

    public float getBtLength() {
        return btLength;
    }

    public void setBtLength(float btLength) {
        this.btLength = btLength;
    }

    public float getBtLevel1() {
        return btLevel1;
    }

    public void setBtLevel1(float btLevel1) {
        this.btLevel1 = btLevel1;
    }

    public float getBtLevel2() {
        return btLevel2;
    }

    public void setBtLevel2(float btLevel2) {
        this.btLevel2 = btLevel2;
    }

    public float getBtLevel3() {
        return btLevel3;
    }

    public void setBtLevel3(float btLevel3) {
        this.btLevel3 = btLevel3;
    }

    public float getBtLevel4() {
        return btLevel4;
    }

    public void setBtLevel4(float btLevel4) {
        this.btLevel4 = btLevel4;
    }

    public float getBtLevel5() {
        return btLevel5;
    }

    public void setBtLevel5(float btLevel5) {
        this.btLevel5 = btLevel5;
    }

    public float getBtLevel6() {
        return btLevel6;
    }

    public void setBtLevel6(float btLevel6) {
        this.btLevel6 = btLevel6;
    }

    public Integer getBtSuccess() {
        return btSuccess;
    }

    public void setBtSuccess(Integer btSuccess) {
        this.btSuccess = btSuccess;
    }

    public Integer getBtTimes() {
        return btTimes;
    }

    public void setBtTimes(Integer btTimes) {
        this.btTimes = btTimes;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
