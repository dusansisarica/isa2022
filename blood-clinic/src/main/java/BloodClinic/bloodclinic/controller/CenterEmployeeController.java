package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.ComplaintForCenterDto;
import BloodClinic.bloodclinic.dto.ComplaintForWorkerDto;
import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.model.ComplaintForWorker;
import BloodClinic.bloodclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/employee")
@RestController
@CrossOrigin
public class CenterEmployeeController {
    @Autowired
    private UserService userService;

    @PostMapping("/complaint")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ComplaintForWorker> writeComplaintForEmployee(@RequestBody ComplaintForWorkerDto complaint){
        return new ResponseEntity<>(userService.writeComplaintForEmployee(complaint), HttpStatus.OK);
    }
}