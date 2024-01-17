package com.example.project.jwt.service;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.project.jwt.config.userDetails;
import com.example.project.jwt.config.userDetailsServi;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthFilterService extends OncePerRequestFilter{

	private final JwtService jwtService;
	
	private final userDetailsServi userDetailsServi;
	
	public AuthFilterService(JwtService jwtService,userDetailsServi userDetailsServi) {
		this.jwtService =jwtService;
		this.userDetailsServi=userDetailsServi;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authHeader = request.getHeader("Authorization");
		String jwt;
		String email;
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
		filterChain.doFilter(request, response);
		return;
		}
		//extract jwt
		jwt = authHeader.substring(7);
		
		//extract email from JWT
		email = jwtService.extractEmail(jwt);
		
		if(email !=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
			UserDetails userDetails =userDetailsServi.loadUserByUsername(email);
			if (jwtService.isTokenValid(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			}
		}

	}
}
	

