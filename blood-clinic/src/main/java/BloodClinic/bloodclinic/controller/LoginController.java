package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.LoginDto;
import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "api/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PutMapping(consumes = "application/json")
    public ResponseEntity<UserDto> saveUser(@RequestBody LoginDto loginDto) {
        UserDto loggedIn = userService.login(loginDto);
        if (loggedIn == null || !loggedIn.activated){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(loggedIn, HttpStatus.OK);
    }
}
