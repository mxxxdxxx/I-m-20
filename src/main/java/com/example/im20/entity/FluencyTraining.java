package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "fluency_training")
public class FluencyTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fluency_training_id")
    private Integer fluencyTrainingId;

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;
}
