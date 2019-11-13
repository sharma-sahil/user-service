package com.nagarro.nagp.user.constants;

/**
 * The Class UserConstants.
 */
public class UserConstants {

	/** The Constant USER_NOT_FOUND. */
	public static final String USER_NOT_FOUND = "User with User id: {} does not exist";

	/** The Constant USER_NOT_FOUND_ERROR_MESSAGE_PREFIX. */
	public static final String USER_NOT_FOUND_ERROR_MESSAGE_PREFIX = "User with User id:";

	/** The Constant USER_NOT_FOUND_ERROR_MESSAGE_SUFFIX. */
	public static final String USER_NOT_FOUND_ERROR_MESSAGE_SUFFIX = " does not exist";

	/** The Constant ACCOUNT_NOT_FOUND. */
	public static final String ACCOUNT_NOT_FOUND = "Account with account number: {} does not exist";

	/** The Constant ACCOUNT_NOT_FOUND_ERROR_MESSAGE_PREFIX. */
	public static final String ACCOUNT_NOT_FOUND_ERROR_MESSAGE_PREFIX = "Account with account number: ";

	/** The Constant ACCOUNT_NOT_FOUND_ERROR_MESSAGE_SUFFIX. */
	public static final String ACCOUNT_NOT_FOUND_ERROR_MESSAGE_SUFFIX = " does not exist";

	/**
	 * Instantiates a new user constants.
	 */
	private UserConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
