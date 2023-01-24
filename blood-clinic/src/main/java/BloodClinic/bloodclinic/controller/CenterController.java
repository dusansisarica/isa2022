package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.security.util.TokenUtils;
import BloodClinic.bloodclinic.service.CenterService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(value = "api/centers")
@RestController
@CrossOrigin
public class CenterController {
    @Autowired
    private CenterService centerService;

    @GetMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<CenterDto>> findAll(){
        return new ResponseEntity<>(centerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AppointmentDto>> findAvailableAppointments(@PathVariable Integer id){
        return new ResponseEntity<>(centerService.findAvailableAppointments(id), HttpStatus.OK);
    }
}
