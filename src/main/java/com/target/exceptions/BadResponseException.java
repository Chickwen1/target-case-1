package com.target.exceptions;

/*
 * Exception thrown when external call is invalid
 */
public class BadResponseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadResponseException(String message) {
		super(message);
	}
}
