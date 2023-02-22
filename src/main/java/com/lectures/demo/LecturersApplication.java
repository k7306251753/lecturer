package com.lectures.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableTransactionManagement

public class LecturersApplication {
	
	Logger log = LoggerFactory.getLogger(LecturersApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LecturersApplication.class, args);
			
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	
}

