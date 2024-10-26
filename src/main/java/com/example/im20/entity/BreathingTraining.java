package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "breathing_training")
public class BreathingTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breathing_training_id")
    private Integer breathingTrainingId;

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;

    @Column(name = "total_breaths", nullable = true)
    private Integer totalBreaths;

    @Column(name = "average_length", nullable = true)
    private Float averageLength;

    @Column(name = "total_success_cnt", nullable = true)
    private Integer totalSuccessCnt;

    @OneToMany(mappedBy = "btSummary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BreathingTrainingDetails> details;
}
