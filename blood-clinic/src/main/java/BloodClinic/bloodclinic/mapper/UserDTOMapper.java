package BloodClinic.bloodclinic.mapper;

import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.model.Gender;
import BloodClinic.bloodclinic.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOMapper {
    private static ModelMapper modelMapper;
    @Autowired
    public UserDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static User fromDTOtoModel(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public static UserDto fromModeltoDTO(User model) {
        return modelMapper.map(model, UserDto.class);
    }

    public static User fromRegistrationDTOtoModel(RegistrationDto registrationDto){
        return new User(null, registrationDto.email, registrationDto.passwordFirst, registrationDto.name, registrationDto.surname, AddressDtoMapper.fromDTOtoModel(registrationDto.address), registrationDto.phone_number, registrationDto.jmbg, registrationDto.job, registrationDto.gender);
    }

    public static List<UserDto> fromModeltoDTOList(List<User> modelList){
        List<UserDto> dto = new ArrayList<>();
        for(User u : modelList){
            dto.add(fromModeltoDTO(u));
        }
        return dto;
    }

}
