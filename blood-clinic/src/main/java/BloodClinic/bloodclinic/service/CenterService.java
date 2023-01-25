package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.dto.CenterAppointmentDto;
import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.dto.ComplaintForCenterDto;
import BloodClinic.bloodclinic.mapper.CenterDtoMapper;
import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.repository.CenterRepositrory;
import BloodClinic.bloodclinic.repository.ComplaintForCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CenterService {

    @Autowired
    private CenterRepositrory centerRepositrory;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private CenterDtoMapper centerDtoMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ComplaintForCenterRepository complaintRepository;

    public List<CenterDto> findAll(String sort_by) {
        switch (sort_by) {
            case "asc(name)":
                return filterByNameAsc();
            case "desc(name)":
                return filterByNameDesc();
            case "asc(avgGrade)":
                return filterByAvgGradeAsc();
            case "desc(avgGrade)":
                return filterByAvgGradeDesc();
            default:
                return centerDtoMapper.fromModeltoDTOList(centerRepositrory.findAll());
        }
    }

    public CenterAppointmentDto findAvailableAppointments(Integer id, String sort_by) {
        List<Appointment> availableAppointments = appointmentService.findAllAvailableForOneCenterModel(centerRepositrory.findById(id).orElse(null));
        CenterAppointmentDto centerAppointmentDto = new CenterAppointmentDto();
        centerAppointmentDto.setCenter(centerRepositrory.findById(id).orElse(null));
        switch (sort_by) {
            case "asc(date)":
                centerAppointmentDto.setAppointments(appointmentService.sortFinishedAppointmentsByDateAsc(availableAppointments));
                return centerAppointmentDto;
            case "desc(date)":
                centerAppointmentDto.setAppointments(appointmentService.sortFinishedAppointmentsByDateDesc(availableAppointments));
                return centerAppointmentDto;
            case "asc(duration)":
                centerAppointmentDto.setAppointments(appointmentService.sortFinishedAppointmentsByDurationAsc(availableAppointments));
                return centerAppointmentDto;
            case "desc(duration)":
                centerAppointmentDto.setAppointments(appointmentService.sortFinishedAppointmentsByDurationDesc(availableAppointments));
                return centerAppointmentDto;
            default:
                centerAppointmentDto.setAppointments(appointmentService.findAllAvailableForOneCenter(centerRepositrory.findById(id).orElse(null)));
                return centerAppointmentDto;
        }
    }

    public List<CenterDto> filterByNameAsc() {
        List<Center> allCenters = centerRepositrory.findAll((Sort.by(Sort.Direction.ASC, "name")));
        return centerDtoMapper.fromModeltoDTOList(allCenters);
    }

    public List<CenterDto> filterByNameDesc() {
        List<Center> allCenters = centerRepositrory.findAll((Sort.by(Sort.Direction.DESC, "name")));
        return centerDtoMapper.fromModeltoDTOList(allCenters);
    }

    public List<CenterDto> filterByAvgGradeAsc() {
        List<Center> allCenters = centerRepositrory.findAll((Sort.by(Sort.Direction.ASC, "avgGrade")));
        //allCenters.sort(Comparator.comparing(Center::getName));
        return centerDtoMapper.fromModeltoDTOList(allCenters);
    }

    public List<CenterDto> filterByAvgGradeDesc() {
        List<Center> allCenters = centerRepositrory.findAll((Sort.by(Sort.Direction.DESC, "avgGrade")));
        //allCenters.sort(Comparator.comparing(Center::getName));
        return centerDtoMapper.fromModeltoDTOList(allCenters);
    }

    public ComplaintForCenter writeComplaintForCenter(ComplaintForCenterDto complaint) {
        ComplaintForCenter complaintForCenter = new ComplaintForCenter();
        complaintForCenter.setCenter(centerRepositrory.findById(complaint.getCenter_id()).orElse(null));
        complaintForCenter.setUser(userService.findByEmail(complaint.getUser()));
        complaintForCenter.setText(complaint.getText());
        complaintRepository.save(complaintForCenter);
        return complaintForCenter;
    }
}
