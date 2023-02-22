package com.lectures.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.lectures.demo.model.LecturerDetailsEntity;

@Repository
public interface LectRepostry extends JpaRepository<LecturerDetailsEntity, Long> {

	
	
	
	  @Query("select l from LecturerDetailsEntity l where  l.lectid=:deptname")
	  List<LecturerDetailsEntity> gettingSameDept(long deptname);
	 
	 
}
