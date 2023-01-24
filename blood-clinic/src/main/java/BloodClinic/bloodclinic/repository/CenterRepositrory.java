package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepositrory extends JpaRepository<Center, Integer> {
}
