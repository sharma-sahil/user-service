package com.nagarro.nagp.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.user.dao.IAccountDAO;
import com.nagarro.nagp.user.dao.IUserDAO;
import com.nagarro.nagp.user.dto.AccountDTO;
import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.dto.UpdateAccountRequest;
import com.nagarro.nagp.user.dto.UpdateUserInfoRequest;
import com.nagarro.nagp.user.dto.UserDTO;
import com.nagarro.nagp.user.exception.InvalidParameterException;
import com.nagarro.nagp.user.model.Account;
import com.nagarro.nagp.user.model.User;
import com.nagarro.nagp.user.service.IUserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements IUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IAccountDAO accountDAO;

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userDAO.getAllUsers();

		List<UserDTO> userDTOs = new ArrayList<>();
		if (null != users && users.size() > 0) {
			users.forEach(u -> userDTOs.add(transformUserToUserDTO(u)));
		}

		return userDTOs;
	}

	@Override
	public UserDTO getUser(long id) throws InvalidParameterException {
		User user = this.userDAO.getUser(id);

		if (null == user) {
			throw new InvalidParameterException("User with User id: " + id + "does not exist");
		}

		return transformUserToUserDTO(user);
	}

	@Override
	public UserDTO createUser(CreateUserRequest request) {

		LOGGER.debug("Creating a new User");
		User newUser = this.userDAO.createUser(request);

		Account account = new Account();
		account.setAccountNumber(request.getUserAccount().getAccountNumber());
		account.setBalance(request.getUserAccount().getBalance());
		account.setUserId(newUser.getUserID());
		account.setBranch(request.getUserAccount().getBranch());

		this.accountDAO.createAccount(account);

		return transformUserToUserDTO(newUser);
	}

	@Override
	public UserDTO updateUserInfo(final long userId, final UpdateUserInfoRequest request)
			throws InvalidParameterException {
		LOGGER.debug("Updating user info");
		User user = this.userDAO.getUser(userId);
		if (null == user) {
			throw new InvalidParameterException("User with User id: " + userId + "does not exist");
		}
		if (null != request.getCity()) {
			user.setCity(request.getCity());
		}
		if (null != request.getCountry()) {
			user.setCountry(request.getCountry());
		}
		if (null != request.getFirstName()) {
			user.setFirstName(request.getFirstName());
		}
		if (null != request.getLastName()) {
			user.setLastName(request.getLastName());
		}
		if (null != request.getState()) {
			user.setState(request.getState());
		}
		this.userDAO.updateUser(user);
		return transformUserToUserDTO(user);
	}

	@Override
	public List<AccountDTO> getUserAccounts(long userId) throws InvalidParameterException {
		User user = this.userDAO.getUser(userId);
		if (null == user) {
			throw new InvalidParameterException("User with User id: " + userId + "does not exist");
		}
		List<Account> userAccounts = this.accountDAO.getUserAccounts(userId);
		return transformAccountDTOs(userAccounts);
	}

	@Override
	public AccountDTO getAccount(final String accountNumber) throws InvalidParameterException {
		Account account = this.accountDAO.getAccount(accountNumber);
		if (null == account) {
			throw new InvalidParameterException("Account with account number: " + accountNumber + "does not exist");
		}

		AccountDTO retVal = new AccountDTO();
		BeanUtils.copyProperties(account, retVal);
		return retVal;
	}

	@Override
	public AccountDTO updateAccountDetails(final String accountNumber, UpdateAccountRequest request)
			throws InvalidParameterException {

		LOGGER.debug("Updating {} of account: {}", request.getAction(), accountNumber);

		AccountDTO retVal = new AccountDTO();
		Account account = this.accountDAO.getAccount(accountNumber);
		if (null == account) {
			throw new InvalidParameterException("Account with account number: " + accountNumber + "does not exist");
		}
		switch (request.getAction()) {
		case UPDATE_BALANCE:
			account.setBalance(request.getBalance());
			break;
		case UPDATE_BRANCH:
			account.setBranch(request.getBranch());
			break;
		default:
			break;
		}
		this.accountDAO.updateAccount(account);
		BeanUtils.copyProperties(account, retVal);

		return retVal;
	}

	private UserDTO transformUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		List<Account> userAccounts = this.accountDAO.getUserAccounts(user.getUserID());
		BeanUtils.copyProperties(user, userDTO);
		userDTO.setUserAccounts(transformAccountDTOs(userAccounts));
		return userDTO;
	}

	private List<AccountDTO> transformAccountDTOs(List<Account> accounts) {
		List<AccountDTO> accountDTOs = new ArrayList<>();
		if (null != accounts && accounts.size() > 0) {
			accounts.forEach(a -> {
				AccountDTO dto = new AccountDTO();
				BeanUtils.copyProperties(a, dto);
				accountDTOs.add(dto);
			});
		}
		return accountDTOs;
	}

}
