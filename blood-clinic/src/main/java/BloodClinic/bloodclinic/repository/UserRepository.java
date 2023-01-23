package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByVerificationCode(String code);
    User findByEmailAndPassword(String email, String password);
}
