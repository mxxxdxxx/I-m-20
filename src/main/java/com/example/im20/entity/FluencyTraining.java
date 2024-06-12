package im20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@EntityScan
@Table(name = "fluency_training")
public class FluencyTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fluency_training_id")
    private Integer fluencyTrainingId;

    @Column(name = "ft_feedback", columnDefinition = "LONGTEXT")
    private String ftFeedback;

    @ManyToOne
    @JoinColumn(name = "manage_id", nullable = false)
    private Manage manage;

    // Getters and Setters
    public Integer getFluencyTrainingId() {
        return fluencyTrainingId;
    }

    public void setFluencyTrainingId(Integer fluencyTrainingId) {
        this.fluencyTrainingId = fluencyTrainingId;
    }

    public String getFtFeedback() {
        return ftFeedback;
    }

    public void setFtFeedback(String ftFeedback) {
        this.ftFeedback = ftFeedback;
    }

    public Manage getManage() {
        return manage;
    }

    public void setManage(Manage manage) {
        this.manage = manage;
    }
}
