package com.example.im20.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PronunciationTrainingDTO {
    private Integer ptId;
    private Integer ptAccuracy;
    private String ptFeedback;
    private String ptWords;
    private Integer ptTimes;
    private String ptTeacher;
    private String ptPic;
    private String ptStdVoice;
    private Integer manageId;

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    // Getters and Setters
    public Integer getPtAccuracy() {
        return ptAccuracy;
    }

    public void setPtAccuracy(Integer ptAccuracy) {
        this.ptAccuracy = ptAccuracy;
    }

    public String getPtFeedback() {
        return ptFeedback;
    }

    public void setPtFeedback(String ptFeedback) {
        this.ptFeedback = ptFeedback;
    }

    public String getPtWords() {
        return ptWords;
    }

    public void setPtWords(String ptWords) {
        this.ptWords = ptWords;
    }

    public Integer getPtTimes() {
        return ptTimes;
    }

    public void setPtTimes(Integer ptTimes) {
        this.ptTimes = ptTimes;
    }

    public String getPtTeacher() {
        return ptTeacher;
    }

    public void setPtTeacher(String ptTeacher) {
        this.ptTeacher = ptTeacher;
    }

    public String getPtPic() {
        return ptPic;
    }

    public void setPtPic(String ptPic) {
        this.ptPic = ptPic;
    }

    public String getPtStdVoice() {
        return ptStdVoice;
    }

    public void setPtStdVoice(String ptStdVoice) {
        this.ptStdVoice = ptStdVoice;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
