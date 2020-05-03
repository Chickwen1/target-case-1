package com.target.controllers;

import static com.target.Constants.INVALID_PRODUCT_EXCEPTION;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.target.exceptions.ErrorMessage;
import com.target.exceptions.InvalidProductException;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidProductException.class)
	public ResponseEntity<?> handleException(InvalidProductException e) {
		ErrorMessage errorMessage = new ErrorMessage(INVALID_PRODUCT_EXCEPTION);
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
