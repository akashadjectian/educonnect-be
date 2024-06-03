package com.edu.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	

    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        mailSender.send(message);
    }
    public void sendVerificationEmail(String to, String token) throws MessagingException {
        String ngrokUrl = "https://c67f-2405-201-4041-c076-fd84-2ee8-4308-10fe.ngrok-free.app";  // Replace with your actual Ngrok URL
        String verificationUrl = ngrokUrl + "/user/verify-email?token=" + token;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject("Email Verification");

        String htmlContent = "<p>Please verify your email by clicking the button below:</p>"
                           + "<a href=\"" + verificationUrl + "\" style=\"display: inline-block; padding: 10px 20px; font-size: 16px; color: #fff; background-color: #007bff; text-decoration: none; border-radius: 5px;\">Verify Email</a>";

        helper.setText(htmlContent, true); // true indicates that the text is HTML

        mailSender.send(message);
    }

    
    
    
}
