package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.CenterAdministrator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintForEmployeeReturnDto {
    public Integer id;
    public CenterAdministrator centerAdministrator;
    public String user;
    public String text;
}
