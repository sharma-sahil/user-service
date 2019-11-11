package com.nagarro.nagp.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.user.dao.IUserDAO;
import com.nagarro.nagp.user.model.User;
import com.nagarro.nagp.user.service.IUserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public User getUser(long id) {
		return this.userDAO.getUser(id);
	}

	@Override
	public User createUser(User user) {
		return this.userDAO.createUser(user);
	}

}
