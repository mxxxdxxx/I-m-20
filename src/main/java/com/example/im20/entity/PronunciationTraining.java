package com.example.im20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pronunciation_training")
public class PronunciationTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pronunciation_training_id")
    private Integer pronunciationTrainingId;

    @Column(name = "pt_accuracy")
    private Integer ptAccuracy;

    @Column(name = "pt_feedback", columnDefinition = "LONGTEXT")
    private String ptFeedback;

    @Column(name = "pt_words")
    private String ptWords;

    @Column(name = "pt_times")
    private Integer ptTimes;

    @Column(name = "pt_teacher")
    private String ptTeacher;

    @Column(name = "pt_pic")
    private String ptPic;

    @Column(name = "pt_std_voice")
    private String ptStdVoice;

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;

    // Getters and Setters
    public Integer getPronunciationTrainingId() {
        return pronunciationTrainingId;
    }

    public void setPronunciationTrainingId(Integer pronunciationTrainingId) {
        this.pronunciationTrainingId = pronunciationTrainingId;
    }

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

    public Manage getManage() {
        return manage;
    }

    public void setManage(Manage manage) {
        this.manage = manage;
    }
}
