package com.example.project.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.jwt.config.userDetails;
import com.example.project.jwt.model.User;
import com.example.project.jwt.service.AuthFilterService;
import com.example.project.jwt.service.JwtService;
import com.example.project.jwt.service.UserService;
import com.example.project.jwt.utils.AuthResponse;
import com.example.project.jwt.utils.LoginRequest;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class userController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthFilterService authService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to this endpoint";
	}
	
	@GetMapping("/get")
	@PreAuthorize("hsAuthority('ADMIN')")
	public List<User> getAllUser(){
		return userService.getData();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		userService.saveData(user);
		return "new user is added";
	}
	
//	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest)
//	{
//		return ResponseEntity.ok(authService.login(loginRequest));
//		
//	}    @PostMapping("/generateToken") 
//    public String authenticateAndGetToken(@RequestBody LoginRequest loginRequest) { 
//        Authentication authentication = authenticationManager.authenticate((Authentication) new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())); 
//        if (authentication.isAuthenticated()) { 
//            return jwtService.generateToken(loginRequest.getEmail()); 
//        } else { 
//            throw new RuntimeException("invalid user request !"); 
//        } 
//    }

	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody LoginRequest loginRequest) { 
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
	    ); 

	    if (authentication.isAuthenticated()) { 
	        userDetails userDetails = (userDetails) authentication.getPrincipal();
	        if (userDetails != null) {
	            return jwtService.generateToken(userDetails);
	        } else {
	            return jwtService.generateToken(loginRequest.getEmail());
	        }
	    } else { 
	        throw new RuntimeException("Invalid user request!");
	    } 
	}

}
