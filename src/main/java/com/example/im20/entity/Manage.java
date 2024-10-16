package com.example.im20.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "manage")
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manage_id")
    private Integer manageId;

    @Column(name = "manage_date", nullable = true)
    private java.time.LocalDate manageDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "breathing_feedback", columnDefinition = "LONGTEXT", nullable = true)
    private String breathingFeedback;

    @Column(name = "fluency_feedback", columnDefinition = "LONGTEXT", nullable = true)
    private String fluencyFeedback;

    @Column(name = "pronunciation_feedback", columnDefinition = "LONGTEXT", nullable = true)
    private String pronunciationFeedback;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BreathingTraining> breathingTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FluencyTraining> fluencyTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PronunciationTraining> pronunciationTrainings;
}