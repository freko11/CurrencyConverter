package com.fdmgroup.converter;

/**
 * Invalid From Currency exception class. 
 * <p>An exception is thrown when invalid from currency operation occurs.
 * 
 * @author Wei Jie
 * @version 1.0
 */
public class InvalidFromCurrencyException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param  message return message
	 */
	public InvalidFromCurrencyException(String message) {
		super(message);
	}
}
