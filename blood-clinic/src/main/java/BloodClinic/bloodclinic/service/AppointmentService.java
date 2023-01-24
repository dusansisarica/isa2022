package BloodClinic.bloodclinic.service;

import BloodClinic.bloodclinic.dto.AppointmentDto;
import BloodClinic.bloodclinic.mapper.AppointmentDtoMapper;
import BloodClinic.bloodclinic.model.Appointment;
import BloodClinic.bloodclinic.model.Center;
import BloodClinic.bloodclinic.model.User;
import BloodClinic.bloodclinic.model.UserAppointment;
import BloodClinic.bloodclinic.repository.AppointmentRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentDtoMapper appointmentDtoMapper;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserAppointmentService userAppointmentService;

    public List<AppointmentDto> findFinishedAppointmentsForUser(String email) {
        return appointmentDtoMapper.fromModeltoDTOList(appointmentRepository.findByUserAndDoneTrue(userService.findByEmail(email)));
    }

    public List<AppointmentDto> findScheduledAppointmentsForUser(String email) {
        return appointmentDtoMapper.fromModeltoDTOList(appointmentRepository.findByUserAndDoneFalse(userService.findByEmail(email)));
    }

    public AppointmentDto cancelScheduledAppointmentsForUser(Integer id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (canAppointmentBeCanceled(appointment)) return cancelAppointment(appointment);
        return appointmentDtoMapper.fromModeltoDTO(appointment);
    }

    public boolean canAppointmentBeCanceled(Appointment appointment) {
        if (appointment.getStartDate().isAfter(LocalDateTime.now().plusHours(24))) return true;
        return false;
    }

    public AppointmentDto cancelAppointment(Appointment appointment) {
        User user = appointment.getUser();
        user.getAppointments().remove(appointment);
        userService.save(user);
        appointment.setUser(null);
        appointmentRepository.save(appointment);
        return appointmentDtoMapper.fromModeltoDTO(appointment);
    }

    public List<AppointmentDto> findAllAvailableForOneCenter(Center center) {
        return appointmentDtoMapper.fromModeltoDTOList(appointmentRepository.findAllByCenterAndUserNull(center));
    }

    public AppointmentDto scheduleAppointment(Integer id, String email) throws Exception {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        User user = userService.findByEmail(email);
        if (userAppointmentService.findAppointment(user, appointment) != null){
            return null;
        }
        appointment.setUser(user);
        user.getAppointments().add(appointment);
        appointmentRepository.save(appointment);
        userService.save(user);
        UserAppointment userAppointment = new UserAppointment();
        userAppointment.setAppointment(appointment);
        userAppointment.setUser(user);
        userAppointmentService.save(userAppointment);
        sendEmail(appointment);
        return appointmentDtoMapper.fromModeltoDTO(appointment);
    }

    public static byte[] getQRCodeImage(String text) throws WriterException, IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFFC041 ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    private void sendEmail(Appointment appointment) throws Exception {
        String toAddress = appointment.getUser().getEmail();
        String fromAddress = "bloodclinicisa";
        String senderName = "Blood Clinic";
        String subject = "You scheduled an appointment!";
        String content = "Dear [[name]], " + "We're happy to inform you that you scheduled your appointment in [[center]] " + "Thank you, " + "Blood Clinic.";

        StringBuilder sb = new StringBuilder();
        sb.append(" Place: " + appointment.getCenter().getName()
                + " Address: " +appointment.getCenter().getAddress()
                + " Time: " + appointment.getStartDate());
        content += sb.toString();
        MimeBodyPart textPart = new MimeBodyPart();
        content = content.replace("[[name]]", appointment.getUser().getName());
        content = content.replace("[[center]]", appointment.getCenter().getName());
        textPart.setContent(content, "text/plain; charset=UTF-8");

        Multipart multiPart = new MimeMultipart("alternative");

        // create a new imagePart and add it to multipart so that the image is inline attached in the email
        byte[] rawImage = getQRCodeImage(sb.toString());
        BodyPart imagePart = new MimeBodyPart();
        ByteArrayDataSource imageDataSource = new ByteArrayDataSource(rawImage,"image/png");

        imagePart.setDataHandler(new DataHandler(imageDataSource));
        imagePart.setHeader("Content-ID", "<qrImage>");
        imagePart.setFileName("someFileName.png");

        multiPart.addBodyPart(imagePart);
        multiPart.addBodyPart(textPart);
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
        message.setSubject(subject);
        message.setContent(multiPart);

        mailSender.send(message);
    }
}
