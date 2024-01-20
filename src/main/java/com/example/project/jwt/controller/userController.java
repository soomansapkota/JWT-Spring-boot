package com.example.project.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.jwt.model.User;
import com.example.project.jwt.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class userController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public List<User> getAllUser(){
		return userService.getData();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		userService.saveData(user);
		return "new user is added";
	}
	

}
