package com.lectures.demo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lectures.demo.LecturersApplication;
import com.lectures.demo.exception.LecturerDublicateException;
import com.lectures.demo.model.LecturerDetailsEntity;
import com.lectures.demo.repositry.LectRepostry;
import com.lectures.demo.service.LectService;

@Service
public class LectServiceImpl implements LectService {
	Logger log = LoggerFactory.getLogger(LecturersApplication.class);
	@Autowired
	private LectRepostry lectRepostry;
	
	
	
	public LecturerDetailsEntity createLecturer(LecturerDetailsEntity lecturerDetailsEntity) {
		
		
		log.info("lecturerDetailsEntity is entered in the lectrer repositry");
		log.debug("lecturerDetailsEntity is entered in the lectrer repositry");
		log.warn("lecturerDetailsEntity is entered in the lectrer repositry");
		log.error("lecturerDetailsEntity is entered in the lectrer repositry");
		
		try {
			return lectRepostry.save(lecturerDetailsEntity);
		} catch (Exception e) {

			throw new LecturerDublicateException(
					" lecturerDublicate " + lecturerDetailsEntity.getLectName() + "Already Existed");

		}
	}

	public List<LecturerDetailsEntity> getAllLecturers() {

		List<LecturerDetailsEntity> entityList = (List<LecturerDetailsEntity>) lectRepostry.findAll();

		return entityList;

	}

	@Override
	public LecturerDetailsEntity getLectById(long id) {

		try {
			return lectRepostry.findById(id).get();
		} catch (Exception e) {
			throw new LecturerDublicateException("id not aviaiale");
		}
		// return lectRepostry.findById(id).get();
	}

	@Override
	public void deleteLecturerById(long id) {
		lectRepostry.deleteById(id);

	}

	@Override
	public Page<LecturerDetailsEntity> getAllLecturersBeforeSort(int pageno, int pageSize, String SortedBy) {
		PageRequest page = PageRequest.of(pageno - 1, pageSize, Sort.by(SortedBy));
		return lectRepostry.findAll(page);
	}

	@Override
	public List<LecturerDetailsEntity> getingEmpWhoAreWorkingSameDept(long deptname) {
		List<LecturerDetailsEntity> k = lectRepostry.gettingSameDept(deptname);
	
		return k;
	}
	//@EventListener(ApplicationReadyEvent.class)
	

	

	

}
