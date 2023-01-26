package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.ComplaintForCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintForCenterRepository extends JpaRepository<ComplaintForCenter, Integer> {
    List<ComplaintForCenter> findAllByAnsweredFalse();
}
