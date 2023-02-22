package com.lectures.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class LecturerDublicateException extends RuntimeException{
public LecturerDublicateException(String msg) {
	super(msg);
	
}


}
