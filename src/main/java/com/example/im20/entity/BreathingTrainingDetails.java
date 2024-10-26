package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "breathing_training_details")
public class BreathingTrainingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breathing_training_id")
    private Integer breathingTrainingId;

    @ManyToOne
    @JoinColumn(name = "bt_summary_id", nullable = false)
    private BreathingTraining btSummary;

    @Column(name = "bt_length", nullable = true)
    private Float btLength;

    @Column(name = "bt_level1", nullable = true)
    private Float btLevel1;

    @Column(name = "bt_level2", nullable = true)
    private Float btLevel2;

    @Column(name = "bt_level3", nullable = true)
    private Float btLevel3;

    @Column(name = "bt_level4", nullable = true)
    private Float btLevel4;

    @Column(name = "bt_level5", nullable = true)
    private Float btLevel5;

    @Column(name = "bt_level6", nullable = true)
    private Float btLevel6;

    @Column(name = "bt_success_cnt", nullable = true)
    private Integer btSuccessCnt;
}
