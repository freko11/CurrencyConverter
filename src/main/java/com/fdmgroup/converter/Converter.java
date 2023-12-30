package com.fdmgroup.converter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.converter.Currency.CurrencyInfo;

/**
 * Class maintaining conversion of currencies
 * <p>
 * Allows conversion of currencies
 * <p>
 * Will throw an exception if currencies are the same, invalid from currency and
 * invalid to currency
 * 
 * @author Wei Jie
 * @version 1.0
 * @see com.fdmgroup.converter.EqualCurrencyException
 * @see com.fdmgroup.converter.InvalidFromCurrencyException
 * @see com.fdmgroup.converter.InvalidToCurrencyException
 * 
 */
public class Converter {

	private static final Logger logger = LogManager.getLogger(Converter.class);

	/**
	 * Convert amount from one currency to another
	 * 
	 * @param fromCurrency	currency to convert
	 * @param toCurrency	currency to get
	 * @param amount	amount to convert
	 * @return The converted amount in target currency
	 * @throws EqualCurrencyException check if currencies are equal
	 * @throws InvalidToCurrencyException check if currency to convert is invalid
	 * @throws InvalidFromCurrencyException check if currency to get is invalid
	 * @throws StreamReadException check if able to read Json
	 * @throws DatabindException check if able to serialize java objects
	 * @throws IOException check if I/O issues
	 */
	public double convert(String fromCurrency, String toCurrency, double amount)
			throws StreamReadException, DatabindException, IOException, EqualCurrencyException,
			InvalidFromCurrencyException, InvalidToCurrencyException {

		ObjectMapper mapper = new ObjectMapper();

		Map<String, CurrencyInfo> currencies = mapper.readValue(new File("src/main/resources/fx_rates.json"),
				new TypeReference<Map<String, CurrencyInfo>>() {
				});
		try {

			if (fromCurrency.equals(toCurrency)) {
				throw new EqualCurrencyException("You are changing to and from the same currency");
			} else if (fromCurrency.equals("usd")) {
				if (currencies.get(toCurrency) == null) {
					throw new InvalidToCurrencyException("Unable to convert to currency");
				} else {
					logger.trace("Transaction sucessfull");
					return amount * currencies.get(toCurrency).getRate();
				}

			} else if (currencies.get(fromCurrency) == null) {
				throw new InvalidFromCurrencyException("Unable to convert from currency");
			} else if (toCurrency.equals("usd")) {
				logger.trace("Transaction sucessfull");
				return amount * currencies.get(fromCurrency).getInverseRate();
			} else if (currencies.get(toCurrency) == null) {
				throw new InvalidToCurrencyException("Unable to convert to currency");
			} else {
				CurrencyInfo currencyFrom = currencies.get(fromCurrency);
				CurrencyInfo currencyTo = currencies.get(toCurrency);
				logger.trace("Transaction sucessfull");
				return amount * currencyFrom.getInverseRate() * currencyTo.getRate();
			}

		} catch (EqualCurrencyException e) {
			logger.warn("EqualCurrencyException: {}", e.getMessage(), e);
			return 0;
		} catch (InvalidFromCurrencyException e) {
			logger.error("InvalidFromCurrencyException: {}", e.getMessage(), e);
			return 0;
		} catch (InvalidToCurrencyException e) {
			logger.error("InvalidToCurrencyException: {}", e.getMessage(), e);
			return 0;
		}
	}
}
