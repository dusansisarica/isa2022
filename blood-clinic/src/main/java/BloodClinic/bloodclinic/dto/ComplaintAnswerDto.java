package BloodClinic.bloodclinic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintAnswerDto {
    private String answer;
    private Integer employee;
    private Integer center;
    private String email;
}
