package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.ComplaintAnswerDto;
import BloodClinic.bloodclinic.model.ComplaintAnswer;
import BloodClinic.bloodclinic.model.ComplaintForCenter;
import BloodClinic.bloodclinic.model.ComplaintForWorker;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.repository.ComplaintAnswerRepository;
import BloodClinic.bloodclinic.repository.ComplaintForCenterRepository;
import BloodClinic.bloodclinic.repository.ComplaintForEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class ComplaintsService {
    @Autowired
    private ComplaintForCenterRepository complaintForCenterRepository;
    @Autowired
    private ComplaintForEmployeeRepository complaintForEmployeeRepository;
    @Autowired
    private ComplaintAnswerRepository complaintAnswerRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserService userService;

    public List<ComplaintForCenter> findAllForCenter() {
        return complaintForCenterRepository.findAll();
    }

    public List<ComplaintForWorker> findAllForEmployee() {
        return complaintForEmployeeRepository.findAll();
    }

    public ComplaintAnswer answer(ComplaintAnswerDto complaintAnswer) throws MessagingException, UnsupportedEncodingException {
        ComplaintAnswer answer = new ComplaintAnswer();
        if (complaintAnswer.getCenter() == null) {
            answer.setComplaintForCenter(null);
        } else {
            answer.setComplaintForCenter(complaintForCenterRepository.findById(complaintAnswer.getCenter()).orElse(null));
        }
        if (complaintAnswer.getEmployee() == null) {
            answer.setComplaintForEmployee(null);
        } else {
            answer.setComplaintForEmployee(complaintForEmployeeRepository.findById(complaintAnswer.getEmployee()).orElse(null));
        }
        answer.setAnswer(complaintAnswer.getAnswer());
        answer.setEmail(complaintAnswer.getEmail());
        complaintAnswerRepository.save(answer);
        sendMail(answer);
        return answer;
    }

    public void sendMail(ComplaintAnswer answer) throws MessagingException, UnsupportedEncodingException {
        String toAddress = answer.getEmail();
        String fromAddress = "bloodclinicisa";
        String senderName = "Blood Clinic";
        String subject = "Your complaint has been answered!";
        String content = "Complaint: <br>" + "[[complaint]]<br>" + "Answer: <br>" + "[[answer]]<br>" + "<br>" + "Blood Clinic.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        if (answer.getComplaintForCenter() != null) {
            content = content.replace("[[complaint]]", answer.getComplaintForCenter().getText());
        } else {
            content = content.replace("[[complaint]]", answer.getComplaintForEmployee().getText());
        }
        content = content.replace("[[answer]]", answer.getAnswer());
        helper.setText(content, true);
        mailSender.send(message);
    }

    public List<ComplaintAnswer> findAll() {
        return complaintAnswerRepository.findAll();
    }

    public List<ComplaintAnswer> findAllForUser(Integer id) {
        return complaintAnswerRepository.findByEmail((userService.findUserById(id)).getEmail());
    }
}
