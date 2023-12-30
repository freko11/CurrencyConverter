package com.fdmgroup.converter;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fdmgroup.converter.Runner;

/**
 * Main runner
 * 
 * @author Wei Jie
 * @version 1.0
 * 
 */
public class Runner {

	private static final Logger logger = LogManager.getLogger(Runner.class);

	/**
	 * 
	 * @param args arguments
	 * @throws EqualCurrencyException check for equal currency
	 * @throws InvalidFromCurrencyException check if invalid from currency
	 * @throws StreamReadException check if able to read Json 
	 * @throws DatabindException check if able to serialize java objects
	 * @throws IOException check if I/O issues
	 * @throws InsufficientAmountException check if sufficient amount to convert
	 * @throws InvalidUserException check if user is valid
	 * @throws InvalidToCurrencyException check if invalid to currency
	 */
	public static void main(String[] args) throws EqualCurrencyException, InvalidFromCurrencyException, StreamReadException,
			DatabindException, IOException, InsufficientAmountException, InvalidUserException, InvalidToCurrencyException {
		
		TransactionProcessor tp = new TransactionProcessor();
		
		String filepath = "src/main/resources/transactions.txt";
		
		tp.executeTransaction(filepath);

		tp.updateUsersFile();
	}

}
