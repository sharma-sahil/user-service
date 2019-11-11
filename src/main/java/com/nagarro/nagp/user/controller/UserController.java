package com.nagarro.nagp.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.user.dto.AccountDTO;
import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.dto.UpdateAccountRequest;
import com.nagarro.nagp.user.dto.UserDTO;
import com.nagarro.nagp.user.service.IUserService;

/**
 * The Class UserController.
 */
@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * Creates the user.
	 */
	@PostMapping(value = "/user")
	public UserDTO createUser(@RequestBody final CreateUserRequest user) {
		return this.userService.createUser(user);
	}

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user/{id}")
	public UserDTO getUser(@PathVariable("id") final long id) {
		return this.userService.getUser(id);
	}

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user")
	public List<UserDTO> getAllUser() {
		return this.userService.getAllUsers();

	}

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user/{id}/accounts")
	public List<AccountDTO> getUserAccounts(@PathVariable("id") final long id) {
		return this.userService.getUserAccounts(id);
	}

	/**
	 * Gets the account.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account
	 */
	@GetMapping(value = "/accounts/{accountNumber}")
	public AccountDTO getAccount(@PathVariable("accountNumber") final String accountNumber) {
		return this.userService.getAccount(accountNumber);
	}

	/**
	 * Update account details.
	 *
	 * @param accountNumber
	 *            the account number
	 * @param request
	 *            the request
	 * @return the account DTO
	 */
	@PutMapping(value = "/accounts/{accountNumber}")
	public AccountDTO updateAccountDetails(@PathVariable("accountNumber") final String accountNumber,
			@RequestBody UpdateAccountRequest request) {
		return this.userService.updateAccountDetails(accountNumber, request);
	}

}
