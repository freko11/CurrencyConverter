package com.fdmgroup.converter;

/**
 * EqualCurrency exception class. 
 * <p>An exception is thrown when equal currency operation occurs.
 * 
 * @author Wei Jie
 * @version 1.0
 */
public class EqualCurrencyException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message return message
	 */
	public EqualCurrencyException(String message) {
		super(message);
	}
}
