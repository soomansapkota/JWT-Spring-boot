package com.example.project.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.jwt.repository.UserRepository;

@Service
public class userDetailsServi implements UserDetailsService {
  
	
	public UserRepository userRepo;

	public userDetailsServi(UserRepository userRepo) {
		this.userRepo = userRepo;
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return (UserDetails) userRepo.findByEmail("email").orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}
	
	
  
	
	
}
