package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.model.UserAppointment;
import BloodClinic.bloodclinic.repository.UserAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAppointmentService {
    @Autowired
    private UserAppointmentRepository userAppointmentRepository;

    public void save(UserAppointment userAppointment){
        userAppointmentRepository.save(userAppointment);
    }
}
