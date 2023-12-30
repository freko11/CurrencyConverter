package com.fdmgroup.converter;

import java.util.Date;
import java.util.Map;

/**
 * Class maintaining currency.
 * 
 * @author Wei Jie
 * @version 1.0
 * 
 */
public class Currency {

	/** Used for map of currencies. */
    private Map<String, CurrencyInfo> currencies;

	/**
	 * Getter method to get the {@code currencies} class attribute of the
	 * {@code Currency} object.
	 * 
	 * @return	currencies	map of currencies
	 * 
	 */
    public Map<String, CurrencyInfo> getCurrencies() {
        return currencies;
    }
    
	/**
	 * Setter method to set the {@code currencies} class attribute of the 
	 * {@code Currency} object.
	 * 
	 * @param	currencies map of currencies to set
	 */
    public void setCurrencies(Map<String, CurrencyInfo> currencies) {
        this.currencies = currencies;
    }
    
    /**
     * Class maintaining currencyInfo
     * 
     */
    public static class CurrencyInfo {
        private String code;
        private String alphaCode;
        private int numericCode;
        private String name;
        private double rate;
        private Date date;
        private double inverseRate;

    	/**
    	 * Getter method to get the {@code code} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	code code of currency
    	 * 
    	 */
        public String getCode() {
            return code;
        }
        
    	/**
    	 * Setter method to set the {@code code} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	code code of currencies to set
    	 */
        public void setCode(String code) {
            this.code = code;
        }

    	/**
    	 * Getter method to get the {@code alphaCode} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	alphaCode alphaCode of currency
    	 * 
    	 */
        public String getAlphaCode() {
            return alphaCode;
        }

    	/**
    	 * Setter method to set the {@code alphaCode} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	alphaCode alphaCode of currencies to set
    	 */
        public void setAlphaCode(String alphaCode) {
            this.alphaCode = alphaCode;
        }

    	/**
    	 * Getter method to get the {@code numericCode} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	numericCode numericCode of currency
    	 * 
    	 */
        public int getNumericCode() {
            return numericCode;
        }

    	/**
    	 * Setter method to set the {@code numericCode} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	numericCode numericCode of currencies to set
    	 */
        public void setNumericCode(int numericCode) {
            this.numericCode = numericCode;
        }

    	/**
    	 * Getter method to get the {@code name} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	name name of currency
    	 * 
    	 */
        public String getName() {
            return name;
        }

    	/**
    	 * Setter method to set the {@code name} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	name name of currencies to set
    	 */
        public void setName(String name) {
            this.name = name;
        }

    	/**
    	 * Getter method to get the {@code rate} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	rate rate of currency
    	 * 
    	 */
        public double getRate() {
            return rate;
        }

    	/**
    	 * Setter method to set the {@code rate} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	rate rate of currencies to set
    	 */
        public void setRate(double rate) {
            this.rate = rate;
        }

    	/**
    	 * Getter method to get the {@code date} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	date date of currency
    	 * 
    	 */
        public Date getDate() {
            return date;
        }

    	/**
    	 * Setter method to set the {@code date} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	date date of currencies to set
    	 */
        public void setDate(Date date) {
            this.date = date;
        }

    	/**
    	 * Getter method to get the {@code inverseRate} class attribute of the
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @return	inverseRate inverseRate of currency
    	 * 
    	 */
        public double getInverseRate() {
            return inverseRate;
        }

    	/**
    	 * Setter method to set the {@code inverseRate} class attribute of the 
    	 * {@code CurrencyInfo} object.
    	 * 
    	 * @param	inverseRate inverseRate of currencies to set
    	 */
        public void setInverseRate(double inverseRate) {
            this.inverseRate = inverseRate;
        }
    }
}
