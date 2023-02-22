package com.lectures.demo.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.lectures.demo.exception.Exceptionresponce;
import com.lectures.demo.exception.LecturerDublicateException;

@ControllerAdvice
/* @RestController */
public class LecturerGlobalCustomExceptionHandler  {
	@ExceptionHandler
	public ResponseEntity<Exceptionresponce> handelLecturerDublicate(LecturerDublicateException ex,
			WebRequest request) {
		Exceptionresponce errorMsg = new Exceptionresponce(ex.getMessage());
		return new ResponseEntity<Exceptionresponce>(errorMsg, HttpStatus.BAD_REQUEST);

	}
}
