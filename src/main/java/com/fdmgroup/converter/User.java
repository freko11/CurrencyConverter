package com.fdmgroup.converter;

import java.util.Map;
import java.util.Objects;

/**
 * Class maintaining user name and wallet.
 * 
 * @author Wei Jie
 * @version 1.0
 * 
 */
public class User {

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}
	
	/** Used for user name. */
	private String name;
	
	/** Used for the user wallet. */
	private Map<String, Double> wallet;

	
	/**
	 * Getter method to get the {@code name} class attribute of the
	 * {@code User} object.
	 * 
	 * @return user name in lowercase
	 */
	public String getName() {
		return name.toLowerCase();
	}

	/**
	 * Setter method to set the {@code name} class attribute of the 
	 * {@code User} object.
	 * 
	 * @param	name name of the user to set
	 */
	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	/**
	 * Getter method to get the {@code wallet} class attribute of the
	 * {@code User} object.
	 * 
	 * @return user wallet
	 */
	public Map<String, Double> getWallet() {
		return wallet;
	}

	/**
	 * Setter method to set the {@code wallet} class attribute of the 
	 * {@code User} object.
	 * 
	 * @param	wallet wallet of the user to set
	 */
	public void setWallet(Map<String, Double> wallet) {
		this.wallet = wallet;
	}

	public String toString() {
		return name;
	}

}
