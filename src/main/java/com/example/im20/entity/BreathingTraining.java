package im20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;
}
