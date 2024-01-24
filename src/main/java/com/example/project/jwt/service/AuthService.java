//package com.example.project.jwt.service;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.demo.model.UserRole;
//import com.example.project.jwt.config.userDetails;
//import com.example.project.jwt.repository.UserRepository;
//import com.example.project.jwt.utils.AuthResponse;
//import com.example.project.jwt.utils.RegisterRequest;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//private PasswordEncoder passwordEncoder;
//private UserRepository userRepo;
//
//
//public AuthResponse register(RegisterRequest registerRequest)
//{
//	var user = userDetails.builder()
//			.name(registerRequest.getName())
//			.email(registerRequest.getEmail())
//			.password(passwordEncoder.encode(registerRequest.getPassword()))
//			.build();
//}
//}
