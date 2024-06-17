package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "ft_feedback", columnDefinition = "LONGTEXT")
    private String ftFeedback;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;
}
