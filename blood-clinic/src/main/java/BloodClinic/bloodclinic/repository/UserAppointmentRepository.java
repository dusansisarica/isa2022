package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.model.UserAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAppointmentRepository extends JpaRepository<UserAppointment, Integer> {
    UserAppointment findByAppointmentAndUser(Appointment appointment, User user);
    List<UserAppointment> findAllByUser(User user);
}
