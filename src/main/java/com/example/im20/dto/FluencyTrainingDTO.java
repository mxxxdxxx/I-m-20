package im20.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluencyTrainingDTO {
    private Integer ftId;
    private String ftFeedback;
    private Integer manageId;

    public Integer getFtId() {
        return ftId;
    }

    public void setFtId(Integer btId) {
        this.ftId = ftId;
    }

    // Getters and Setters
    public String getFtFeedback() {
        return ftFeedback;
    }

    public void setFtFeedback(String ftFeedback) {
        this.ftFeedback = ftFeedback;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
