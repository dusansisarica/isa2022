package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.model.UserAppointment;
import BloodClinic.bloodclinic.repository.UserAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppointmentService {
    @Autowired
    private UserAppointmentRepository userAppointmentRepository;

    public void save(UserAppointment userAppointment){
        userAppointmentRepository.save(userAppointment);
    }

    public UserAppointment findAppointment(User user, Appointment appointment){
        return userAppointmentRepository.findByAppointmentAndUser(appointment, user);
    }

    public List<UserAppointment> findAllByUser(User user){
        return userAppointmentRepository.findAllByUser(user);
    }
}
