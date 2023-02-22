package com.lectures.demo.serviceImpl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PrintingBySedular {
	//@Scheduled(cron ="0 28 19 2 1 MON" )
	public void printings() {
		
		System.out.println("i am eritator");
	}

}
