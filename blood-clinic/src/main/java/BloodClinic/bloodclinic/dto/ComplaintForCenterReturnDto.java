package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Center;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintForCenterReturnDto {
    public Integer id;
    public Center center;
    public String user;
    public String text;
}
