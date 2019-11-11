package com.nagarro.nagp.user.service;

import java.util.List;

import com.nagarro.nagp.user.dto.AccountDTO;
import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.dto.UpdateAccountRequest;
import com.nagarro.nagp.user.dto.UpdateUserInfoRequest;
import com.nagarro.nagp.user.dto.UserDTO;

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
	 */
	public UserDTO getUser(long id);

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
	 */
	List<AccountDTO> getUserAccounts(long userId);

	/**
	 * Update account details.
	 *
	 * @param request
	 *            the request
	 * @return the account DTO
	 */
	AccountDTO updateAccountDetails(String accountNumber, UpdateAccountRequest request);

	/**
	 * Gets the account.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account
	 */
	AccountDTO getAccount(String accountNumber);

	/**
	 * Update user info.
	 *
	 * @param userId the user id
	 * @param request the request
	 * @return the user DTO
	 */
	UserDTO updateUserInfo(long userId, UpdateUserInfoRequest request);

}
