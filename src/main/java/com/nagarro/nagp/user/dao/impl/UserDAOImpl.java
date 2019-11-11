package com.nagarro.nagp.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.dao.IUserDAO;
import com.nagarro.nagp.user.model.User;

/**
 * The Class UserDAOImpl.
 */
@Component
public class UserDAOImpl implements IUserDAO {

	private static List<User> users = new ArrayList<>();

	@Override
	public User createUser(User user) {
		user.setUserID(getNewUserId());
		users.add(user);
		return users.get(users.size() - 1);
	}

	@Override
	public User getUser(long userId) {

		Optional<User> userOpt = users.stream().filter(u -> u.getUserID() == userId).findFirst();
		if (userOpt.isPresent()) {
			return userOpt.get();
		}

		return null;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	private long getNewUserId() {

		long userId = 1L;
		if (null != users && users.size() > 1) {
			userId = users.get(users.size() - 1).getUserID() + 1;
		}

		return userId;
	}

}
