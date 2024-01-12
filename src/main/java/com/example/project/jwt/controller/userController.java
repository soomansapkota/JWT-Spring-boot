package com.example.project.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
	
	@RequestMapping("/welcome")
	public String Home()
	{
		String text ="Hello world";
		return text;
	}

}
