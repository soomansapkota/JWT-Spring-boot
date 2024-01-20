package com.example.project.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.jwt.model.User;
import com.example.project.jwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveData(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getData(){
		return userRepo.findAll();
	}
	
}


