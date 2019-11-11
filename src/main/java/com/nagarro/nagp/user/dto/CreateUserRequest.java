package com.nagarro.nagp.user.dto;

/**
 * The Class CreateUserRequest.
 */
public class CreateUserRequest {

	/** The user ID. */
	private long userID;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The city. */
	private String city;

	/** The state. */
	private String state;

	/** The country. */
	private String country;

	/** The user account. */
	private AccountDTO userAccount;

	/**
	 * Gets the user ID.
	 *
	 * @return the user ID
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userID
	 *            the new user ID
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city
	 *            the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state
	 *            the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country
	 *            the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the user account.
	 *
	 * @return the user account
	 */
	public AccountDTO getUserAccount() {
		return userAccount;
	}

	/**
	 * Sets the user account.
	 *
	 * @param userAccount
	 *            the new user account
	 */
	public void setUserAccount(AccountDTO userAccount) {
		this.userAccount = userAccount;
	}

}
