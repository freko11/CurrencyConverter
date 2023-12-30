package com.fdmgroup.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.converter.Currency.CurrencyInfo;

/**
 * Class maintaining processing of transactions
 * <p>
 * Allows processing of transactions and updating json file
 * <p>
 * Will throw an exception if there are insufficient amount, invalid user,
 * currencies are the same, invalid from currency and invalid to currency
 * 
 * @author Wei Jie
 * @version 1.0
 * @see com.fdmgroup.converter.InvalidFromCurrencyException
 * @see com.fdmgroup.converter.InvalidToCurrencyException
 * @see com.fdmgroup.converter.EqualCurrencyException
 * @see com.fdmgroup.converter.InsufficientAmountException
 * @see com.fdmgroup.converter.InvalidUserException
 * 
 */
public class TransactionProcessor {

	ObjectMapper mapper = new ObjectMapper();
	List<User> users;
	private static final Logger logger = LogManager.getLogger(TransactionProcessor.class);

	/**
	 * 
	 * @param filename enter filepath
	 * @throws EqualCurrencyException       check for equal currency
	 * @throws InvalidFromCurrencyException check if invalid from currency
	 * @throws InsufficientAmountException  check if sufficient amount to convert
	 * @throws InvalidUserException         check if user is valid
	 * @throws InvalidToCurrencyException   check if invalid to currency
	 */
	public void executeTransaction(String filename) throws EqualCurrencyException, InvalidFromCurrencyException,
			InsufficientAmountException, InvalidUserException, InvalidToCurrencyException {

		

		String userFilePath = "src/main/resources/users.json";

		try {

			Converter converter = new Converter();

			users = mapper.readValue(new File(userFilePath), new TypeReference<ArrayList<User>>() {
			});

			Map<String, CurrencyInfo> currencies = mapper.readValue(new File("src/main/resources/fx_rates.json"),
					new TypeReference<Map<String, CurrencyInfo>>() {
					});

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = br.readLine()) != null) {

				String[] words = line.split(" ");

				User testUser = new User();
				testUser.setName(words[0].toLowerCase());

				try {
					if (!users.contains(testUser)) {
						throw new InvalidUserException("The user does not exist");
					} else if (users.contains(testUser)) {
						String fromCurrency = (String) words[1];
						String toCurrency = (String) words[2];
						double amountToChange = Double.parseDouble(words[3]);

						double convertedAmount = converter.convert(fromCurrency, toCurrency, amountToChange);

						for (User user : users) {
							if (testUser.getName().equals(user.getName())) {
								Map<String, Double> wallet = user.getWallet();

								try {
									if (convertedAmount == 0) {
										logger.warn("Transaction voided");
									} else if (wallet.get(words[1]) == null) {
										throw new InvalidFromCurrencyException("Unable to convert from currency");
									} else if (wallet.get(words[1]) < amountToChange) {
										throw new InsufficientAmountException(
												"You do not have enough " + words[1] + " to change");
									} else if (wallet.get(words[2]) == null) {
										wallet.put(words[1], wallet.get(words[1]) - amountToChange);
										wallet.put(words[2], convertedAmount);
										logger.trace("Transaction sucessfull");
									} else {
										wallet.put(words[1], wallet.get(words[1]) - amountToChange);
										wallet.put(words[2], wallet.get(words[2]) + convertedAmount);
										logger.trace("Transaction sucessfull");
									}
								} catch (InvalidFromCurrencyException e) {
									logger.error("InvalidFromCurrencyException: {}", e.getMessage(), e);
								} catch (InsufficientAmountException e) {
									logger.error("InsufficientAmountException: {}", e.getMessage(), e);
								} 
							}
						}
					}
				} catch (InvalidUserException e) {
					logger.error("InvalidUserException: {}", e.getMessage(), e);
				}

			}

		} catch (StreamReadException e) {
			logger.error("Error during JSON parsing: {}", e.getMessage(), e);
		} catch (DatabindException e) {
			logger.error("Error during JSON data binding: {}", e.getMessage(), e);
		} catch (IOException e) {
			logger.error("IO Exception occurred: {}", e.getMessage(), e);
		}
	}

	/**
	 * Method to update users file
	 */
	public void updateUsersFile() {

		try {
			mapper.writeValue(new File("src/main/resources/updated_users.json"), users);
		} catch (StreamReadException e) {
			logger.error("Error during JSON parsing: {}", e.getMessage(), e);
		} catch (DatabindException e) {
			logger.error("Error during JSON data binding: {}", e.getMessage(), e);
		} catch (IOException e) {
			logger.error("IO Exception occurred: {}", e.getMessage(), e);
		}
	}
}
