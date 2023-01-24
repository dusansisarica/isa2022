package BloodClinic.bloodclinic.controller;


import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.security.util.TokenUtils;
import BloodClinic.bloodclinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "api/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin
public class AppointmentController {

    private TokenUtils tokenUtils;

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(TokenUtils tokenHelper) {
        this.tokenUtils = tokenHelper;
    }


    @GetMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AppointmentDto>> findFinishedAppointments(HttpServletRequest request){
        return new ResponseEntity<>(appointmentService.findFinishedAppointmentsForUser(tokenUtils.getEmailFromToken(tokenUtils.getToken(request))), HttpStatus.OK);

    }
}
