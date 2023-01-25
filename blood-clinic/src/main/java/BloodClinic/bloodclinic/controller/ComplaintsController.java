package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.*;
import BloodClinic.bloodclinic.model.ComplaintAnswer;
import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.model.ComplaintForWorker;
import BloodClinic.bloodclinic.security.util.TokenUtils;
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

    private TokenUtils tokenUtils;

    public ComplaintsController(TokenUtils tokenHelper) {
        this.tokenUtils = tokenHelper;
    }

    @GetMapping("/center")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintForCenterReturnDto>> findAllForCenter(){
        return new ResponseEntity<>(complaintsService.findAllForCenter(), HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintAnswer>> findAllAnswered(){
        return new ResponseEntity<>(complaintsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/answered")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ComplaintAnswerReturnDto>> findAllAnsweredForUser(HttpServletRequest request){
        String email = tokenUtils.getEmailFromToken(tokenUtils.getToken(request));
        return new ResponseEntity<>(complaintsService.findAllForUser(email), HttpStatus.OK);
    }

    @PostMapping("/answer")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ComplaintAnswer> answer(@RequestBody ComplaintAnswerDto complaintAnswer) throws MessagingException, UnsupportedEncodingException {
        return new ResponseEntity<>(complaintsService.answer(complaintAnswer), HttpStatus.OK);
    }


    @GetMapping("/employee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ComplaintForEmployeeReturnDto>> findAllForEmployee(){
        return new ResponseEntity<>(complaintsService.findAllForEmployee(), HttpStatus.OK);
    }
}
