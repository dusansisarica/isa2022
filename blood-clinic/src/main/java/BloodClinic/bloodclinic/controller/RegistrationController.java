package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDto> saveCourse(@RequestBody RegistrationDto registrationDto) {
        if (!registrationDto.passwordFirst.equals(registrationDto.passwordSecond))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (userService.emailExists(registrationDto.email)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.save(registrationDto), HttpStatus.CREATED);
    }
}
