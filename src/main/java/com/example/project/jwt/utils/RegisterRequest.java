package com.example.project.jwt.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

	private int id;
	private String name;
	private String address;
	private String email;
	private String password;
	
}
