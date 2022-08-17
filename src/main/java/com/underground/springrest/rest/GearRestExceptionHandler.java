package com.underground.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GearRestExceptionHandler {
	// Add an exception handler for GearNotFoundException
	
		@ExceptionHandler
		public ResponseEntity<GearErrorResponse> handleException(GearNotFoundException exc) {
			
			// create GearErrorResponse
			
			GearErrorResponse error = new GearErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		
		// Add another exception handler ... to catch any exception (catch all)

		@ExceptionHandler
		public ResponseEntity<GearErrorResponse> handleException(Exception exc) {
			
			// create GearErrorResponse
			
			GearErrorResponse error = new GearErrorResponse(
												HttpStatus.BAD_REQUEST.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
}
