package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.dto.ComplaintAnswerDto;
import BloodClinic.bloodclinic.model.ComplaintAnswer;
import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.model.ComplaintForWorker;
import BloodClinic.bloodclinic.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping(value = "api/complaints")
@RestController
@CrossOrigin
public class ComplaintsController {
    @Autowired
    private ComplaintsService complaintsService;

    @GetMapping("/center")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintForCenter>> findAllForCenter(){
        return new ResponseEntity<>(complaintsService.findAllForCenter(), HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintAnswer>> findAllAnswered(){
        return new ResponseEntity<>(complaintsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ComplaintAnswer>> findAllAnsweredForUser(@PathVariable Integer id){
        return new ResponseEntity<>(complaintsService.findAllForUser(id), HttpStatus.OK);
    }

    @PostMapping("/answer")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ComplaintAnswer> answer(@RequestBody ComplaintAnswerDto complaintAnswer) throws MessagingException, UnsupportedEncodingException {
        return new ResponseEntity<>(complaintsService.answer(complaintAnswer), HttpStatus.OK);
    }


    @GetMapping("/employee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintForWorker>> findAllForEmployee(){
        return new ResponseEntity<>(complaintsService.findAllForEmployee(), HttpStatus.OK);
    }
}
