package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.security.util.TokenUtils;
import BloodClinic.bloodclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    private TokenUtils tokenUtils;

    public UserController(TokenUtils tokenHelper) {
        this.tokenUtils = tokenHelper;
    }

    @PutMapping("/survey")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDto> changeSurvey(HttpServletRequest request) {
        String email = tokenUtils.getEmailFromToken(tokenUtils.getToken(request));
        return new ResponseEntity<>(userService.changeSurvey(email), HttpStatus.OK);
    }
}
