package com.app.ecommerce.exception_handler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.ecommerce.custom_exception.*;
import com.app.ecommerce.dto.ErrorResponse;

@ControllerAdvice // common advice on exception handling for all controllers
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> map = ex.getFieldErrors().stream() // Stream<FieldError>
																				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		// builder pattern 				(400)
		return ResponseEntity.badRequest().body(map);
	}
	
// ****************************************************************************
	
	@ExceptionHandler(ResourceNotFoundException.class) // name of our own defined class
	public ResponseEntity<?> handleResourseNotFoundException(ResourceNotFoundException e){
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	// equivalent catch-all block
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e){
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}
}
