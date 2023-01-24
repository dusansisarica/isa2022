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
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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


    @GetMapping("/finished")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AppointmentDto>> findFinishedAppointments(HttpServletRequest request, @RequestParam(value = "sort_by", defaultValue = "") String sort_by){
        return new ResponseEntity<>(appointmentService.findFinishedAppointmentsForUser(tokenUtils.getEmailFromToken(tokenUtils.getToken(request)), sort_by), HttpStatus.OK);
    }

    @GetMapping("/scheduled")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AppointmentDto>> findScheduledAppointments(HttpServletRequest request){
        return new ResponseEntity<>(appointmentService.findScheduledAppointmentsForUser(tokenUtils.getEmailFromToken(tokenUtils.getToken(request))), HttpStatus.OK);
    }

    @GetMapping("/cancel/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<AppointmentDto> cancelScheduledAppointments(@PathVariable Integer id){
        return new ResponseEntity<>(appointmentService.cancelScheduledAppointmentsForUser(id), HttpStatus.OK);
    }

    @GetMapping("/schedule/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<AppointmentDto> scheduleAppointment(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        String email = tokenUtils.getEmailFromToken(tokenUtils.getToken(request));
        AppointmentDto appointmentDto = appointmentService.scheduleAppointment(id, email);
        if (appointmentDto != null) return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
