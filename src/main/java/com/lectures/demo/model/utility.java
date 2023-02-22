package com.lectures.demo.model;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class utility {
		
		public static void main(String[] args) {
			
			BCryptPasswordEncoder ps= new BCryptPasswordEncoder();
			
			System.out.println(ps.encode("krishna"));
			
			
			
		}

	}

