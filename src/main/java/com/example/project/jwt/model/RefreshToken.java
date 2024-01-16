package com.example.project.jwt.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class RefreshToken {
	@Id
	@GeneratedValue
	private Integer tokenId;
	private String refreshToken;
	private Instant expirationTime;
	
	@OneToOne
	private User user;
	
}
