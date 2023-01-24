package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.mapper.AppointmentDtoMapper;
import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<AppointmentDto> findScheduledAppointmentsForUser(String email) {
        return appointmentDtoMapper.fromModeltoDTOList(appointmentRepository.findByUserAndDoneFalse(userService.findByEmail(email)));
    }

    public AppointmentDto cancelScheduledAppointmentsForUser(Integer id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (canAppointmentBeCanceled(appointment)) return cancelAppointment(appointment);
        return appointmentDtoMapper.fromModeltoDTO(appointment);
    }

    public boolean canAppointmentBeCanceled(Appointment appointment){
        if (appointment.getStartDate().isAfter(LocalDateTime.now().plusHours(24))) return true;
        return false;
    }

    public AppointmentDto cancelAppointment(Appointment appointment){
        User user = appointment.getUser();
        user.getAppointments().remove(appointment);
        userService.save(user);
        appointment.setUser(null);
        appointmentRepository.save(appointment);
        return appointmentDtoMapper.fromModeltoDTO(appointment);
    }
}
