package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByUserAndDoneTrue(User user);
}
