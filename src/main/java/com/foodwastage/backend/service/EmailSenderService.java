package com.foodwastage.backend.service;

import com.foodwastage.backend.model.EmailDetails;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;


public interface EmailSenderService {
    String sendSimpleMail(EmailDetails emailDetails);
}
