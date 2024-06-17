package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "manage")
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manage_id")
    private Integer manageId;

    @Column(name = "manage_date")
    private LocalDate manageDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BreathingTraining> breathingTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL)
    private List<FluencyTraining> fluencyTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL)
    private List<PronunciationTraining> pronunciationTrainings;
}