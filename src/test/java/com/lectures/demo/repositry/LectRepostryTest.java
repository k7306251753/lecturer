package com.lectures.demo.repositry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.lectures.demo.model.LecturerDetailsEntity;

@DataJpaTest
public class LectRepostryTest {
	
	@Autowired
	private LectRepostry lectRepostry;
	 // JUnit test for save employee operation
    @DisplayName("JUnit test for save employee operation")
  
	
	@Test
    public void saveLectureReturnsLecturer() {
	   //given
    	LecturerDetailsEntity e1= new LecturerDetailsEntity();
    	
    	e1.setLectid(89);
    	e1.setLectName("siva");
    	e1.setLectExperience("4 years"); 
    	e1.setLectHireDate("2022-11-28 11:14:31.790000");
    	e1.setLectBranch("mba");
    	//System.out.println(e1);
    	
    	//when
    	
    	LecturerDetailsEntity newemp = lectRepostry.save(e1);
    
    	
    	//then
    	assertThat(newemp).isNotNull();
    
    }
    
   @Test
    public void custonQuarey() {
	   
	   //givin
    	LecturerDetailsEntity e1= new LecturerDetailsEntity();
    	e1.setLectid(89);
    	e1.setLectName("siva");
    	e1.setLectExperience("4 years"); 
    	e1.setLectHireDate("2022-11-28 11:14:31.790000");
    	e1.setLectBranch("mba");
    	LecturerDetailsEntity e2= new LecturerDetailsEntity();
    	e2.setLectid(89);
    	e2.setLectName("siva");
    	e2.setLectExperience("4 years"); 
    	e2.setLectHireDate("2022-11-28 11:14:31.790000");
    	e2.setLectBranch("mba");
    	List<LecturerDetailsEntity>l= new ArrayList();
    	
    	
    	List<LecturerDetailsEntity>l1=lectRepostry.saveAll(l);
    
    	assertThat(l1).isNotNull();
    	
    	
    	
    }
}
