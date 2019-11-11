package com.nagarro.nagp.user.dao;

import com.nagarro.nagp.user.model.User;

/**
 * The Interface IUserDAO.
 */
public interface IUserDAO {

	public User createUser(User user);

	User getUser(long userId);

}
