package com.target.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Creating custom exception for when a product id does not exist in database
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductException(String message) {
		super(message);
	}
}
