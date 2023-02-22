package com.lectures.demo.service;


import java.util.List;

import javax.mail.MessagingException;

import org.springframework.data.domain.Page;


import com.lectures.demo.dto.LectDto;

import com.lectures.demo.model.LecturerDetailsEntity;

public interface LectService {
	public LecturerDetailsEntity createLecturer(LecturerDetailsEntity lecturerDetailsEntity);
	
	public List<LecturerDetailsEntity> getAllLecturers();
	public LecturerDetailsEntity getLectById(long id);
	public void deleteLecturerById(long id);
	Page<LecturerDetailsEntity> getAllLecturersBeforeSort(int pageno,int pageSize,String SortedBy);
	

	public List<LecturerDetailsEntity> getingEmpWhoAreWorkingSameDept(long deptname);
	//public void mailSeduler(String setTo,String setText,String setSubject) throws MessagingException;
}
