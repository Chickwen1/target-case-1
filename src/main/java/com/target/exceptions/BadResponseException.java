package com.target.exceptions;

/*
 * Exception thrown when external call is invalid
 */
public class BadResponseException extends RuntimeException {

	public BadResponseException(String message) {
		super(message);
	}
}
