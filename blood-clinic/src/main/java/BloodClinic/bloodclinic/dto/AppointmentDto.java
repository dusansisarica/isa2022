package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDto {
    private Integer id;
    private LocalDateTime startDate;
    private Duration duration;
    //private UserDto user;
    private boolean done;
}
