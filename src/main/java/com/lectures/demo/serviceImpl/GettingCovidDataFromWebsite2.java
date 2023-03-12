package com.lectures.demo.serviceImpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lectures.demo.service.RestfulWebservicecovidCAses;
@Service
public class GettingCovidDataFromWebsite2 implements RestfulWebservicecovidCAses{

	@Autowired
	private RestTemplate restTemplate;
	@Value("${tracker.COVID_DATA_URL}")
	private String url;
	@Override
	public String getCovidDataFromWorld() {
		HttpHeaders headers= new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		
		
		
		
		
		
		String covidData=restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		return covidData;
	}

}
