package com.lectures.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lectures.demo.model.CovidDataEntity;

@Service
public interface PutCovidDataService {

	List<CovidDataEntity> saveAllCovidList(List<CovidDataEntity> covidData);
	
	

}
