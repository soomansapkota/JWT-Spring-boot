package com.example.project.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class userConfig{
	
	private final userDetailsServi userdetailsservice;
	
	public userConfig(userDetailsServi userdetailsservice)
	{
		this.userdetailsservice =userdetailsservice;
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception
	{
		httpSecurity
		.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/","/home").permitAll()
				
				.anyRequest().authenticated())
		
				.formLogin((form) -> form
						.loginPage("/login")
						.defaultSuccessUrl("/")
						.loginProcessingUrl("/")
						.permitAll()
					);
		httpSecurity.authenticationProvider(authenticationProvider());
				
		return httpSecurity.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("/images/**", "/js/**", "/css/**");
	}

	
	@Bean
	public BCryptPasswordEncoder bcryptPassEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		// TODO Auto-generated method stub
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userdetailsservice);
		authenticationProvider.setPasswordEncoder(bcryptPassEncoder());
		return authenticationProvider;
	}
	
}
