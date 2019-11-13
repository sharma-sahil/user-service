package com.nagarro.nagp.user.exception;

/**
 * The Class InvalidParametreException.
 */
public class InvalidParameterException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7121608588987771292L;

	/**
	 * Instantiates a new invalid paramtere exception.
	 *
	 * @param message
	 *            the message
	 */
	public InvalidParameterException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid paramtere exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public InvalidParameterException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
