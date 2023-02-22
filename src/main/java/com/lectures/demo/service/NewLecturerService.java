package com.lectures.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface NewLecturerService {
	public  UserDetails loadUserByUsername(String usernameOrEmail) ;
	      
}
