package com.lectures.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.batch.operations.JobRestartException;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lectures.demo.LecturersApplication;
import com.lectures.demo.model.CovidDataEntity;
import com.lectures.demo.model.LecturerDetailsEntity;
import com.lectures.demo.service.LectService;
import com.lectures.demo.service.PutCovidDataService;
import com.lectures.demo.service.RestfulWebservicecovidCAses;

@RestController
@RequestMapping("/lecturer/operations")
@EnableScheduling
public class LectController {
	@Autowired
	
	private JavaMailSender mailSenderj1;
	
	@Autowired
	private com.lectures.demo.service.OrderService orderService;
	Logger log = LoggerFactory.getLogger(LecturersApplication.class);
	@Autowired
	private LectService lectService;
	@Autowired
	private RestfulWebservicecovidCAses restfulWebservicecovidCAses;
	@Autowired 
	private PutCovidDataService putCovidDataService;
	@Autowired
	private EntityManager em;
	

	@PreAuthorize("hasRole('ADMIN')")//apexon
	@PostMapping("/")
	
	public ResponseEntity<?> createLecturer(@Valid @RequestBody LecturerDetailsEntity lecturerDetailsEntity,
			BindingResult results) {

		if (lecturerDetailsEntity != null) {
			// Logger log = LoggerFactory.getLogger(LecturersApplication.class);
			log.info("lecturerDetailsEntity is entered in the lectrer controller");
			log.debug("lecturerDetailsEntity is entered in the lectrer controller");
			log.warn("lecturerDetailsEntity is entered in the lectrer controller");
			log.error("lecturerDetailsEntity is entered in the lectrer controller");
		}

		if (results.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			for (FieldError error : results.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		LecturerDetailsEntity Lectentity = lectService.createLecturer(lecturerDetailsEntity);
		return new ResponseEntity<LecturerDetailsEntity>(Lectentity, HttpStatus.CREATED);

	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editLecturer(@Valid @RequestBody LecturerDetailsEntity lecturerDetailsEntity,
			BindingResult results) {

		if (lecturerDetailsEntity != null) {
			// Logger log = LoggerFactory.getLogger(LecturersApplication.class);
			log.info("lecturerDetailsEntity is entered in the lectrer controller");
			log.debug("lecturerDetailsEntity is entered in the lectrer controller");
			log.warn("lecturerDetailsEntity is entered in the lectrer controller");
			log.error("lecturerDetailsEntity is entered in the lectrer controller");
		}

		if (results.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			for (FieldError error : results.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		LecturerDetailsEntity Lectentity = lectService.createLecturer(lecturerDetailsEntity);
		return new ResponseEntity<LecturerDetailsEntity>(Lectentity, HttpStatus.CREATED);

	}

	@GetMapping("/getAllLectures")
	public ResponseEntity<?> getAllLecturescontroll() {
		List<LecturerDetailsEntity> lectEntity = lectService.getAllLecturers();
		System.out.println(mailSenderj1.hashCode()+"are"+mailSenderj2.hashCode());

		return new ResponseEntity<List<LecturerDetailsEntity>>(lectEntity, HttpStatus.OK);

	}

	@GetMapping("/getByLectureId/{id}")
	public ResponseEntity<LecturerDetailsEntity> getLecturerById(@PathVariable("id") long id) {
		LecturerDetailsEntity entity = lectService.getLectById(id);

		return new ResponseEntity<LecturerDetailsEntity>(entity, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByLectureId/{id}")
	public HttpStatus deleteLecturerById(@PathVariable("id") long id) {
		lectService.deleteLecturerById(id);
		return HttpStatus.OK;
	}

	@GetMapping("/restApiGetCovidData")
	public ResponseEntity<String> getCovidCaseslist() {
		String covidData = restfulWebservicecovidCAses.getCovidDataFromWorld();
		return new ResponseEntity<String>(covidData, HttpStatus.OK);
	}

	@GetMapping("/saveAllCovidData")

	public ResponseEntity<List<CovidDataEntity>> PutCovidDataList(@RequestBody List<CovidDataEntity> covidData) {
		List<CovidDataEntity> k = putCovidDataService.saveAllCovidList(covidData);
		return new ResponseEntity<List<CovidDataEntity>>(k, HttpStatus.OK);

	}

	@GetMapping("/pagenationandsorting")
	public ResponseEntity<Page<LecturerDetailsEntity>> getAllCustomerBeforPage(@RequestParam int pageno,
			@RequestParam int pageSize, @RequestParam String sortedby) {

		Page<LecturerDetailsEntity> customerList = lectService.getAllLecturersBeforeSort(pageno, pageSize, sortedby);
		return new ResponseEntity<Page<LecturerDetailsEntity>>(customerList, HttpStatus.OK);
	}

	@GetMapping("/jpqlQuares")
	public ResponseEntity<List<LecturerDetailsEntity>> getingEmpWhoAreWorkingSameDept(@RequestParam long deptname) {
		List<LecturerDetailsEntity> l = lectService.getingEmpWhoAreWorkingSameDept(deptname);
		return new ResponseEntity<List<LecturerDetailsEntity>>(l, HttpStatus.OK);

	}

	// @EventListener(ApplicationReadyEvent.class)
	@PostMapping("/mailsender")
	// @Scheduled(cron = "0/5 * * * * *")
	public HttpStatus mailSenderWithScheduler() {

		String setTo = "k7306251753@gmail.com";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("k7306251753@gmail.com");
		message.setText("we are friends");
		message.setSubject("we are friends");
		mailSenderj1.send(message);
		log.info("mail sededed to" + setTo);
		// System.out.println("mail send to"+setTo);
		// @RequestParam String setTo,@RequestParam String setText,@RequestParam String
		// setSubject

		return HttpStatus.OK;

	}

	@PostMapping("/transational")
	public ResponseEntity<com.lectures.demo.dto.OrderResponse> placeOrder(
			@RequestBody com.lectures.demo.dto.OrderRequest orderRequest) {
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}
	@GetMapping("/chechingStoredProcedure")
	public ResponseEntity<List<LecturerDetailsEntity>>checkingStoredProcedure(){
		
		List<LecturerDetailsEntity>list=em.createNamedStoredProcedureQuery("fistprocedure").getResultList();
		
		return new ResponseEntity<List<LecturerDetailsEntity>>(list, HttpStatus.CREATED);
	}
		
	@GetMapping("/chechingStoredProcedure2")
	public ResponseEntity<List<LecturerDetailsEntity>>checkingStoredProcedure2(@RequestParam Integer input){
		
		List<LecturerDetailsEntity>list=em.createNamedStoredProcedureQuery("second").setParameter("tlectid", input) .getResultList();
		
		return new ResponseEntity<List<LecturerDetailsEntity>>(list, HttpStatus.CREATED);
	}
		
		// @EventListener(ApplicationReadyEvent.class)
	@PostMapping("/mailsender")
	// @Scheduled(cron = "0/5 * * * * *")
	public HttpStatus mailSenderWithSchedulerf() {

		String setTo = "k7306251753@gmail.com";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("k7306251753@gmail.com");
		message.setText("we are friends");
		message.setSubject("we are friends");
		mailSenderj1.send(message);
		log.info("mail sededed to" + setTo);
		// System.out.println("mail send to"+setTo);
		// @RequestParam String setTo,@RequestParam String setText,@RequestParam String
		// setSubject

		return HttpStatus.OK;

	}
	

}
