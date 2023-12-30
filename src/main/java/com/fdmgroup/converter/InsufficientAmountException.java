package com.fdmgroup.converter;

/**
 * Insufficient Amount exception class. 
 * <p>An exception is thrown when insufficient amount operation occurs.
 * 
 * @author Wei Jie
 * @version 1.0
 */
public class InsufficientAmountException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message return message
	 */
	public InsufficientAmountException(String message) {
		super(message);
	}
}
