package BloodClinic.bloodclinic.controller;

import BloodClinic.bloodclinic.dto.LoginDto;
import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.dto.UserTokenState;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.security.util.TokenUtils;
import BloodClinic.bloodclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "api/login")
public class LoginController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @PutMapping()
    public ResponseEntity<UserTokenState> login(
            @RequestBody LoginDto loginDto, HttpServletResponse response) {
        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.email, loginDto.password));

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        User user = (User) authentication.getPrincipal();
        if (!user.isActivated()) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

}
