package com.lectures.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectures.demo.model.CovidDataEntity;
@Repository
public interface PutCovidDataRepo extends JpaRepository<CovidDataEntity, Long>{

}
