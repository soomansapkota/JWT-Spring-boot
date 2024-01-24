package com.example.project.jwt.service;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import com.example.project.jwt.config.userDetails;
import com.example.project.jwt.config.userDetailsServi;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class AuthFilterService extends OncePerRequestFilter{
    @Autowired
	private final JwtService jwtService;
    @Lazy
	@Autowired
	private final userDetailsServi userDetailsServi;
	
	public AuthFilterService(JwtService jwtService,userDetailsServi userDetailsServi) {
		this.jwtService =jwtService;
		this.userDetailsServi=userDetailsServi;
	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain)
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
				authenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
			}
			
		}
		filterChain.doFilter(request, response);

	}
	
}
	

