package com.learning.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.restfulwebservices.game.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<exception> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		exception errorDetails = new exception(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<exception>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<exception> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		exception errorDetails = new exception(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<exception>(errorDetails, HttpStatus.NOT_FOUND);
		
	}

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		exception errorDetails = new exception(LocalDateTime.now(), 
		"Total Errors: " + ex.getFieldErrors().size() + " Current Error: " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
