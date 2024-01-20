//package com.example.project.jwt.model;
//
//import java.time.Instant;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Table(name="refresh_token")
//public class RefreshToken {
//	
//	@Id
//	@GeneratedValue
//	private Integer tokenId;
//	private String refreshToken;
//	private Instant expirationTime;
//	
//	@OneToOne
//	private User user;
//
//	public Integer getTokenId() {
//		return tokenId;
//	}
//
//	public void setTokenId(Integer tokenId) {
//		this.tokenId = tokenId;
//	}
//
//	public String getRefreshToken() {
//		return refreshToken;
//	}
//
//	public void setRefreshToken(String refreshToken) {
//		this.refreshToken = refreshToken;
//	}
//
//	public Instant getExpirationTime() {
//		return expirationTime;
//	}
//
//	public void setExpirationTime(Instant expirationTime) {
//		this.expirationTime = expirationTime;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//	
//	
//}
