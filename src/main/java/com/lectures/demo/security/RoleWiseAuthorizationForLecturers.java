package com.lectures.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.lectures.demo.serviceImpl.NewLecturerServiceImpl;


  @Configuration
  
  @EnableWebSecurity
  
  @EnableGlobalMethodSecurity(prePostEnabled = true) 
  public class RoleWiseAuthorizationForLecturers extends WebSecurityConfigurerAdapter{
  @Autowired
  private NewLecturerServiceImpl lectService;
  @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println("Hi Which Request");
		
		 http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/lecturer/operations/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
		super.configure(http);
	}
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(lectService)
              .passwordEncoder(passwordEncoder());
  }
  }
 





























































