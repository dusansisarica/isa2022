package BloodClinic.bloodclinic.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;

@Getter
@Setter
public class CenterDto {
    private Integer id;
    private String name;
    private String address;
    private String description;
    private double avgGrade;
    public Set<AppointmentDto> appointments;
}
