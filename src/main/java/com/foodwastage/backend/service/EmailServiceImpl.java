package com.foodwastage.backend.service;

import com.foodwastage.backend.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailSenderService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String receiver;

    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(emailDetails.getSender());
            mailMessage.setTo(receiver);
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setText(emailDetails.getMsgBody());

            javaMailSender.send(mailMessage);
            return "Mail sent successfully !!";
        }
        catch (Exception e){
            return "Error while sending mail";
        }
    }
}
