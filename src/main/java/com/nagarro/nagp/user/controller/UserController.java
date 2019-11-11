package com.nagarro.nagp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.user.model.User;
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
	public User createUser(@RequestBody final User user) {
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
	public User getUser(@PathVariable("id") final long id) {
		return this.userService.getUser(id);

	}

}
