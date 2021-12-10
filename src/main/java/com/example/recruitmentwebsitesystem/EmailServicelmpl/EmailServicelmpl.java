package com.example.recruitmentwebsitesystem.EmailServicelmpl;

import org.springframework.mail.javamail.JavaMailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class EmailServicelmpl {
    private final JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String msg){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
        try {

            MimeMessage message = mailSender.createMimeMessage();

            message.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("cutetiger98.java@gmail.com");
            helper.setTo(to);
            helper.setText(msg, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailServicelmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
