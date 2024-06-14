package com.example.im20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
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
    private Date manageDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL)
    private List<BreathingTraining> breathingTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL)
    private List<FluencyTraining> fluencyTrainings;

    @OneToMany(mappedBy = "manage", cascade = CascadeType.ALL)
    private List<PronunciationTraining> pronunciationTrainings;
}
