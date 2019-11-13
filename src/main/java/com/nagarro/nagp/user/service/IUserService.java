package com.nagarro.nagp.user.service;

import java.util.List;

import com.nagarro.nagp.user.dto.AccountDTO;
import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.dto.UpdateAccountRequest;
import com.nagarro.nagp.user.dto.UpdateUserInfoRequest;
import com.nagarro.nagp.user.dto.UserDTO;
import com.nagarro.nagp.user.exception.InvalidParameterException;

/**
 * The Interface IUserService.
 */
public interface IUserService {

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	public UserDTO getUser(long id) throws InvalidParameterException;

	/**
	 * Creates the user.
	 *
	 * @param request
	 *            the request
	 * @return the user DTO
	 */
	public UserDTO createUser(CreateUserRequest request);

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	List<UserDTO> getAllUsers();

	/**
	 * Gets the user accounts.
	 *
	 * @param userId
	 *            the user id
	 * @return the user accounts
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	List<AccountDTO> getUserAccounts(long userId) throws InvalidParameterException;

	/**
	 * Update account details.
	 *
	 * @param accountNumber
	 *            the account number
	 * @param request
	 *            the request
	 * @return the account DTO
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	AccountDTO updateAccountDetails(String accountNumber, UpdateAccountRequest request)
			throws InvalidParameterException;

	/**
	 * Gets the account.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	AccountDTO getAccount(String accountNumber) throws InvalidParameterException;

	/**
	 * Update user info.
	 *
	 * @param userId
	 *            the user id
	 * @param request
	 *            the request
	 * @return the user DTO
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	UserDTO updateUserInfo(long userId, UpdateUserInfoRequest request) throws InvalidParameterException;

}
