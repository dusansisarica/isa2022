package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.model.UserAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppointmentRepository extends JpaRepository<UserAppointment, Integer> {
}
