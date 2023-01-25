package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.model.ComplaintForWorker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;

@Getter
@Setter
public class ComplaintAnswerReturnDto {
    private Integer id;
    private String answer;
    private String email;
    private ComplaintForWorker complaintForEmployee;
    private ComplaintForCenter complaintForCenter;
}
