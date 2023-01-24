package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.LoginDto;
import BloodClinic.bloodclinic.dto.RegistrationDto;
import BloodClinic.bloodclinic.dto.UserDto;
import BloodClinic.bloodclinic.mapper.UserDTOMapper;
import BloodClinic.bloodclinic.model.Role;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDTOMapper userDTOMapper;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RoleService roleService;

    public UserDto save(RegistrationDto dto, String siteURL)throws MessagingException, UnsupportedEncodingException {
        User user = userDTOMapper.fromRegistrationDTOtoModel(dto);
        user.setActivated(false);
        user.setDeleted(false);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_USER"));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(dto.passwordFirst));
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        sendVerificationEmail(user, siteURL);
        return userDTOMapper.fromModeltoDTO(userRepository.save(user));
    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);
        if (user == null || user.isActivated()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setActivated(true);
            userRepository.save(user);
            return true;
        }
    }

    private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "bloodclinicisa";
        String senderName = "Blood Clinic";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
        + "Please click the link below to verify your registration:<br>"
        + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
        + "Thank you,<br>"
        + "Blood Clinic.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getName());
        String verifyURL = siteURL + "/api/registration/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    public List<UserDto> findAll() {
        return userDTOMapper.fromModeltoDTOList(userRepository.findAll());
    }

    public boolean emailExists(String email){
        if(userRepository.findByEmail(email) != null){
            return true;
        }
        return false;
    }

    public UserDto login(LoginDto loginDto){
        User user = userRepository.findByEmailAndPassword(loginDto.email, loginDto.password);
        if(user != null){
            return userDTOMapper.fromModeltoDTO(user);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        else return user;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void removePenalty() throws InterruptedException {
        List<User> users = userRepository.findAll();
        for (User u : users){
            u.setPenalty(0);
        }
        userRepository.saveAll(users);
    }

/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }*/
}
