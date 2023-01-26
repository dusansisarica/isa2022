package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.ComplaintForWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintForEmployeeRepository extends JpaRepository<ComplaintForWorker, Integer> {
    List<ComplaintForWorker> findAllByAnsweredFalse();
}
