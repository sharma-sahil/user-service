package com.nagarro.nagp.user.service;

import java.util.List;

import com.nagarro.nagp.user.dto.CreateUserRequest;
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

}
