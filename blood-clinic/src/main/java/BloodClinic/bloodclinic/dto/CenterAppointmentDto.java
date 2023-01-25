package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CenterAppointmentDto {
    private Center center;
    private List<AppointmentDto> appointments;
}
