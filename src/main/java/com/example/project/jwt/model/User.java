package com.example.project.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;



@Entity
@Table(name="user_tbl")
@Builder
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRoles userRoles;
	
//	@OneToOne(mappedBy = "user")
//	private RefreshToken refreshToken;
//	
//	
//	public RefreshToken getRefreshToken() {
//		return refreshToken;
//	}
//	public void setRefreshToken(RefreshToken refreshToken) {
//		this.refreshToken = refreshToken;
//	}
	public UserRoles getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
