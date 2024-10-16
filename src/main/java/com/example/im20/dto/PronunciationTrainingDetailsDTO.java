package com.example.im20.dto;

import com.example.im20.entity.PronunciationTraining;
import com.example.im20.entity.PronunciationTrainingDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PronunciationTrainingDetailsDTO {

    private Integer detailId;
    private Integer pronunciationTrainingId;
    private String ptWord;
    private String ptText;
    private String ptChildVoice;
    private String ptTeacherVoice;
    private Integer ptScore;
    private String ptFeedback;
    private Integer index;

    public PronunciationTrainingDetailsDTO(PronunciationTrainingDetails entity) {
        this.detailId = entity.getDetailId();
        this.pronunciationTrainingId = entity.getPronunciationTraining().getPronunciationTrainingId();
        this.ptWord = entity.getPtWord();
        this.ptText = entity.getPtText();
        this.ptChildVoice = entity.getPtChildVoice();
        this.ptTeacherVoice = entity.getPtTeacherVoice();
        this.ptScore = entity.getPtScore();
        this.ptFeedback = entity.getPtFeedback();
        this.index = entity.getIndex();
    }

    // Getters and Setters
    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getPronunciationTrainingId() {
        return pronunciationTrainingId;
    }

    public void setPronunciationTrainingId(Integer pronunciationTrainingId) {
        this.pronunciationTrainingId = pronunciationTrainingId;
    }

    public String getPtWord() {
        return ptWord;
    }

    public void setPtWord(String ptWord) {
        this.ptWord = ptWord;
    }

    public String getPtText() {
        return ptText;
    }

    public void setPtText(String ptText) {
        this.ptText = ptText;
    }

    public String getPtChildVoice() {
        return ptChildVoice;
    }

    public void setPtChildVoice(String ptChildVoice) {
        this.ptChildVoice = ptChildVoice;
    }

    public String getPtTeacherVoice() {
        return ptTeacherVoice;
    }

    public void setPtTeacherVoice(String ptTeacherVoice) {
        this.ptTeacherVoice = ptTeacherVoice;
    }

    public Integer getPtScore() {
        return ptScore;
    }

    public void setPtScore(Integer ptScore) {
        this.ptScore = ptScore;
    }

    public String getPtFeedback() {
        return ptFeedback;
    }

    public void setPtFeedback(String ptFeedback) {
        this.ptFeedback = ptFeedback;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
