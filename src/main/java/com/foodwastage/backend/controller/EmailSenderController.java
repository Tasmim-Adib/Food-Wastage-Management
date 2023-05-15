package com.foodwastage.backend.controller;

import com.foodwastage.backend.model.EmailDetails;
import com.foodwastage.backend.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailService;
    @PostMapping("/api/v1/auth/sendmail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        String status = emailService.sendSimpleMail(emailDetails);
        return status;
    }
}
