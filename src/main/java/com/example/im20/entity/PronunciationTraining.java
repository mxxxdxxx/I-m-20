package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "pt_attempt", nullable = true)
    private Integer ptAttempt;

    @Column(name = "pt_success_cnt", nullable = true)
    private Boolean ptSuccessCnt;

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;

    @OneToMany(mappedBy = "pronunciationTraining", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PronunciationTrainingDetails> details;

    public List<PronunciationTrainingDetails> getDetails() {
        return details;
    }
}
