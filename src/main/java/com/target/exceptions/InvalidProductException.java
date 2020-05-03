package com.target.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidProductException extends RuntimeException {

	public InvalidProductException(String message) {
		super(message);
	}
}
