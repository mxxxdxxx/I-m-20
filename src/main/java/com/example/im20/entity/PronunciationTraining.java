package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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
    @JsonBackReference
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;
}
