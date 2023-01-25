package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;

@Getter
@Setter
public class ComplaintForCenterDto {
    public Integer id;
    public Integer center;
    public String user;
    public String text;
}
