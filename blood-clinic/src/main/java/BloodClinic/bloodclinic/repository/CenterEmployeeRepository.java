package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.CenterAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CenterEmployeeRepository extends JpaRepository<CenterAdministrator, Integer> {
}
