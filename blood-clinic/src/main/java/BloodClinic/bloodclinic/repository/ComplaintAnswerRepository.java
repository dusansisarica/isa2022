package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.ComplaintAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintAnswerRepository extends JpaRepository<ComplaintAnswer, Integer> {
    List<ComplaintAnswer> findByEmail(String email);
}
