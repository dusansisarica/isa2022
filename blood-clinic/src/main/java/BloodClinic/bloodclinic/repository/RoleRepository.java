package BloodClinic.bloodclinic.repository;

import BloodClinic.bloodclinic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
