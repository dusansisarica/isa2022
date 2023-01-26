package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByUserAndDoneTrue(User user);
    List<Appointment> findByUserAndDoneFalse(User user);
    List<Appointment> findAllByCenterAndUserNull(Center center);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from Appointment a where a.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    Appointment findOneById(@Param("id") Integer id);
}
