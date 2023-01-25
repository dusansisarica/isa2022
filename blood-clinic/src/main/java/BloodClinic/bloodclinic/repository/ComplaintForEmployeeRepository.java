package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.ComplaintForWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintForEmployeeRepository extends JpaRepository<ComplaintForWorker, Integer> {
}
