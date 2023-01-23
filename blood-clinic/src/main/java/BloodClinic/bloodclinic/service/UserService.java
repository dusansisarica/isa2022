package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.mapper.UserDTOMapper;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    public UserDto save(RegistrationDto dto){
        return userDTOMapper.fromModeltoDTO(userRepository.save(userDTOMapper.fromRegistrationDTOtoModel(dto)));
    }

    public List<UserDto> findAll() {
        return userDTOMapper.fromModeltoDTOList(userRepository.findAll());
    }

    public boolean emailExists(String email){
        if(userRepository.findByEmail(email) != null){
            return true;
        }
        return false;
    }
}
