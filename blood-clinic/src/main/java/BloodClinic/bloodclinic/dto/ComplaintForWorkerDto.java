package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.CenterAdministrator;
import BloodClinic.bloodclinic.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintForWorkerDto {
    private Integer id;
    private Integer centerAdministrator;
    private String user;
    private String text;
}
