package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.CenterAdministrator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ComplaintForEmployeeReturnDto {
    public Integer id;
    public CenterAdministrator centerAdministrator;
    public String user;
    public String text;
    private boolean answered;
}
