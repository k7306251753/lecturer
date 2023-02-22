package com.lectures.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectures.demo.model.CovidDataEntity;
import com.lectures.demo.repositry.PutCovidDataRepo;
import com.lectures.demo.service.PutCovidDataService;
@Service
public class PutCovidDataServiceImpl implements PutCovidDataService{
@Autowired
	private PutCovidDataRepo putCovidDataRepo;
	
	
	@Override
	public List<CovidDataEntity> saveAllCovidList(List<CovidDataEntity> covidData) {
		putCovidDataRepo.saveAll(covidData);
		return null;
	}

}
