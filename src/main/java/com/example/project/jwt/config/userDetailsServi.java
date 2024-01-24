package com.example.project.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.jwt.repository.UserRepository;

@Service
public class userDetailsServi implements UserDetailsService {
  
	@Autowired
	public UserRepository userRepo;
	
	
	private PasswordEncoder passwordEncoder;

	 public String addUser(com.example.project.jwt.model.User userInfo) { 
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword())); 
	        userRepo.save(userInfo); 
	        return "User Added Successfully"; 
	    } 

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return (UserDetails) userRepo.findByEmail("email").orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}
}
