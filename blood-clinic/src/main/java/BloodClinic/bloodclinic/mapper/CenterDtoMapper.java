package BloodClinic.bloodclinic.mapper;

import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.model.Center;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CenterDtoMapper {
    private static ModelMapper modelMapper;

    @Autowired
    public CenterDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static Center fromDTOtoModel(CenterDto dto) {
        return modelMapper.map(dto, Center.class);
    }

    public static CenterDto fromModeltoDTO(Center model) {
        return modelMapper.map(model, CenterDto.class);
    }

    public static List<CenterDto> fromModeltoDTOList(List<Center> modelList) {
        List<CenterDto> dto = new ArrayList<>();
        for (Center c : modelList) {
            dto.add(fromModeltoDTO(c));
        }
        return dto;
    }
}
