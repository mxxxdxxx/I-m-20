package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "breathing_training")
public class BreathingTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breathing_training_id")
    private Integer breathingTrainingId;

    @Column(name = "bt_length")
    private float btLength;

    @Column(name = "bt_level1")
    private float btLevel1;

    @Column(name = "bt_level2")
    private float btLevel2;

    @Column(name = "bt_level3")
    private float btLevel3;

    @Column(name = "bt_level4")
    private float btLevel4;

    @Column(name = "bt_level5")
    private float btLevel5;

    @Column(name = "bt_level6")
    private float btLevel6;

    @Column(name = "bt_feedback", columnDefinition = "LONGTEXT")
    private String btFeedback;

    @Column(name = "bt_success")
    private Integer btSuccess;

    @Column(name = "bt_times")
    private Integer btTimes;

    // 순환 참조 방지
    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    @JsonBackReference
    private Manage manage;
}
