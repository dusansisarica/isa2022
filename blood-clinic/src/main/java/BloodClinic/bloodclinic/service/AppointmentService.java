package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.mapper.AppointmentDtoMapper;
import BloodClinic.bloodclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentDtoMapper appointmentDtoMapper;
    public List<AppointmentDto> findFinishedAppointmentsForUser(String email) {
        return appointmentDtoMapper.fromModeltoDTOList(appointmentRepository.findByUserAndDoneTrue(userService.findByEmail(email)));
    }
}
