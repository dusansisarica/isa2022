package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.CenterDto;
import BloodClinic.bloodclinic.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/centers", produces = MediaType.APPLICATION_JSON_VALUE)
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
}
