package BloodClinic.bloodclinic.mapper;

import BloodClinic.bloodclinic.dto.AddressDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.model.Address;
import BloodClinic.bloodclinic.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper {
    private static ModelMapper modelMapper;
    @Autowired
    public AddressDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public static Address fromDTOtoModel(AddressDto dto) {
        return modelMapper.map(dto, Address.class);
    }

    public static AddressDto fromModeltoDTO(Address model) {
        return modelMapper.map(model, AddressDto.class);
    }
}
