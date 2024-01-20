package com.example.project.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailServiceImpl {

@Autowired
private JavaMailSender javaMailSender;


public void sendEmail(String to,String subject,String body) {

	
	try {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.getMessage();
	}
	

}


}



