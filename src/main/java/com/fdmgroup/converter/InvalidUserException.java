package com.fdmgroup.converter;

/**
 * Invalid User exception class. 
 * <p>An exception is thrown when invalid user operation occurs.
 * 
 * @author Wei Jie
 * @version 1.0
 */
public class InvalidUserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message return message
	 */
	public InvalidUserException(String message) {
		super(message);
	}
}
