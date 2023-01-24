package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.model.Role;
import BloodClinic.bloodclinic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

}
