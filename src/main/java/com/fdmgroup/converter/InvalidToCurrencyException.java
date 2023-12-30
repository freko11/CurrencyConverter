package com.fdmgroup.converter;

/**
 * Invalid To Currency exception class. 
 * <p>An exception is thrown when invalid to currency operation occurs.
 * 
 * @author Wei Jie
 * @version 1.0
 */
public class InvalidToCurrencyException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message return message
	 */
	public InvalidToCurrencyException(String message) {
		super(message);
	}
}
