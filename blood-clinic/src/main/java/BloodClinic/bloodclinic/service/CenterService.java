package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.mapper.CenterDtoMapper;
import BloodClinic.bloodclinic.repository.CenterRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    @Autowired
    private CenterRepositrory centerRepositrory;
    @Autowired
    private CenterDtoMapper centerDtoMapper;

    public List<CenterDto> findAll(){
        return centerDtoMapper.fromModeltoDTOList(centerRepositrory.findAll());
    }
}
