package BloodClinic.bloodclinic.mapper;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentDtoMapper {
    private static ModelMapper modelMapper;

    @Autowired
    public AppointmentDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static Appointment fromDTOtoModel(AppointmentDto dto) {
        return modelMapper.map(dto, Appointment.class);
    }

    public static AppointmentDto fromModeltoDTO(Appointment model) {
        return modelMapper.map(model, AppointmentDto.class);
    }

    public static List<AppointmentDto> fromModeltoDTOList(List<Appointment> modelList) {
        List<AppointmentDto> dto = new ArrayList<>();
        for (Appointment a : modelList) {
            dto.add(fromModeltoDTO(a));
        }
        return dto;
    }
}
