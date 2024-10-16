package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "pronunciation_training_details")
public class PronunciationTrainingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detailId;

    @ManyToOne
    @JoinColumn(name = "pronunciation_training_id", nullable = false)
    private PronunciationTraining pronunciationTraining;

    @Column(name = "pt_word", nullable = true)
    private String ptWord;

    @Column(name = "pt_text", nullable = true)
    private String ptText;

    @Column(name = "pt_child_voice", nullable = true)
    private String ptChildVoice;

    @Column(name = "pt_teacher_voice", nullable = true)
    private String ptTeacherVoice;

    @Column(name = "pt_score", nullable = true)
    private Integer ptScore;

    @Column(name = "pt_feedback", nullable = true)
    private String ptFeedback;

    @Column(name = "index", nullable = false)
    private Integer index;
}
