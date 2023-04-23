package com.example.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exceptions.ExceptionsResponse;
import com.example.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController			
public class CustomazedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
  
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionsResponse exceptionsResponse = new ExceptionsResponse(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
		ExceptionsResponse exceptionsResponse = new ExceptionsResponse(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(exceptionsResponse, HttpStatus.BAD_REQUEST);
	}
}
