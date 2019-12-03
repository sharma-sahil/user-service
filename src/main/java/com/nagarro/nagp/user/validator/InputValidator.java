package com.nagarro.nagp.user.validator;

import org.springframework.util.StringUtils;

import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.exception.InvalidParameterException;

/**
 * The Class InputValidator.
 */
public class InputValidator {

	private InputValidator() {
		// to prevent initialization
	}

	public static void validateCreateUserRequest(CreateUserRequest request) throws InvalidParameterException {
		if (null == request) {
			throw new InvalidParameterException("Input Request must not be null", "invalid.request");
		}
		if (!StringUtils.hasText(request.getFirstName())) {
			throw new InvalidParameterException("First name must not be null in request", "invalid.request.firstName");
		}
		if (!StringUtils.hasText(request.getLastName())) {
			throw new InvalidParameterException("Last name must not be null in request", "invalid.request.lastName");
		}
		if (!StringUtils.hasText(request.getCity())) {
			throw new InvalidParameterException("City must not be null in request", "invalid.request.city");
		}
		if (!StringUtils.hasText(request.getState())) {
			throw new InvalidParameterException("State must not be null in request", "invalid.request.state");
		}
		if (!StringUtils.hasText(request.getCountry())) {
			throw new InvalidParameterException("Country name must not be null in request", "invalid.request.country");
		}
		if (null == request.getUserAccount()) {
			throw new InvalidParameterException("User Account Info must not be null in request",
					"invalid.request.userAccount");
		}
		if (!StringUtils.hasText(request.getUserAccount().getAccountNumber())) {
			throw new InvalidParameterException("Account number must not be null in request",
					"invalid.userAccount.accountNumber");
		}
		if (!StringUtils.hasText(request.getUserAccount().getBranch())) {
			throw new InvalidParameterException("Branch must not be null in request", "invalid.userAccount.branch");
		}
		if (request.getUserAccount().getBalance() <= 0) {
			throw new InvalidParameterException("Balance must not be null in request", "invalid.userAccount.balance");
		}
	}

}
