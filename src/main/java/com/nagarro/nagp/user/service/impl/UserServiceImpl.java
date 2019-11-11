package com.nagarro.nagp.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.user.dao.IAccountDAO;
import com.nagarro.nagp.user.dao.IUserDAO;
import com.nagarro.nagp.user.dto.AccountDTO;
import com.nagarro.nagp.user.dto.CreateUserRequest;
import com.nagarro.nagp.user.dto.UserDTO;
import com.nagarro.nagp.user.model.Account;
import com.nagarro.nagp.user.model.User;
import com.nagarro.nagp.user.service.IUserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IAccountDAO accountDAO;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userDAO.getAllUsers();
		
		List<UserDTO> userDTOs = new ArrayList<>();
		if(null != users && users.size() > 0){
			users.forEach(u -> userDTOs.add(transformUserToUserDTO(u)));
		}

		return userDTOs;
	}

	@Override
	public UserDTO getUser(long id) {
		User user = this.userDAO.getUser(id);

		return transformUserToUserDTO(user);
	}

	@Override
	public UserDTO createUser(CreateUserRequest request) {

		User newUser = this.userDAO.createUser(request);

		Account account = new Account();
		account.setAccountNumber(request.getUserAccount().getAccountNumber());
		account.setBalance(request.getUserAccount().getBalance());
		account.setUserId(newUser.getUserID());

		this.accountDAO.createAccount(account);

		return transformUserToUserDTO(newUser);
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
				dto.setId(a.getId());
				dto.setAccountNumber(a.getAccountNumber());
				dto.setBalance(a.getBalance());
				accountDTOs.add(dto);
			});
		}
		return accountDTOs;
	}

}
