package com.example.project.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.project.jwt.service.AuthFilterService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class userConfig{
	@Autowired
	private userDetailsServi userdetailsservice;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/api/v1/add","/api/v1/welcome").permitAll()
				
				.anyRequest().authenticated());
		
//				.formLogin((form) -> form
//						.loginPage("/")
//						.defaultSuccessUrl("/")
//						.loginProcessingUrl("/")
//						.permitAll()
//					);
		httpSecurity.authenticationProvider(authenticationProvider());
//		httpSecurity.addFilterBefore(authFilterService, UsernamePasswordAuthenticationFilter.class);
				
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
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
}
