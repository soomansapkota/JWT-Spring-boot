package com.example.project.jwt.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

public class OTPService {
	@Autowired
	private EmailServiceImpl emailServiceImpl;

	public String generateOtp() {
		
		Random random = new Random();
		int otpvalue=10000 + random.nextInt(90000);
		return String.valueOf(otpvalue);
	}
	
	private void sendVerification(String email, String subject,String body,String otp) {
		
		String subject1 = subject;
		String body1 = body + otp;
		emailServiceImpl.sendEmail(email, subject1, body1); 
	}
	
}
