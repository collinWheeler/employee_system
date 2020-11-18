package com.wheeler.employee.contracts;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wheeler.employee.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserAlreadyExistsException.class)
	
	public ResponseEntity<Object> handleUserAlreadyExists(UserAlreadyExistsException exception){
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User already exists");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
