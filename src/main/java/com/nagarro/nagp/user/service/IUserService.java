package com.nagarro.nagp.user.service;

import com.nagarro.nagp.user.model.User;

public interface IUserService {

	public User getUser(long id);

	public User createUser(User user);

}
