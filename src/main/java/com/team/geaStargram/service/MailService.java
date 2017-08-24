package com.team.geaStargram.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@Service
public class MailService {

    @Inject
    private JavaMailSender mailSender;

    public void sendMail(String email, String text)
            throws FileNotFoundException, URISyntaxException {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("geastargram@gmail.com");
            message.setTo(email);
            message.setSubject("GaeStargram");
            message.setText(text);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}