package com.nagarro.nagp.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.dao.IAccountDAO;
import com.nagarro.nagp.user.model.Account;

/**
 * The Class AccountDAOImpl.
 */
@Component
public class AccountDAOImpl implements IAccountDAO {

	private static List<Account> accounts = new ArrayList<>();

	@Override
	public List<Account> getUserAccounts(long userId) {
		return accounts.stream().filter(a -> a.getUserId() == userId).collect(Collectors.toList());
	}

	@Override
	public Account getAccount(long accountId) {
		Optional<Account> accountOpt = accounts.stream().filter(a -> a.getId() == accountId).findFirst();
		if (accountOpt.isPresent()) {
			return accountOpt.get();
		}

		return null;
	}

	@Override
	public Account createAccount(Account account) {
		account.setId(getNewAccountId());
		accounts.add(account);

		return account;
	}

	/**
	 * Gets the new account id.
	 *
	 * @return the new account id
	 */
	private long getNewAccountId() {
		long accountId = 1L;
		if (null != accounts && accounts.size() > 1) {
			accountId = accounts.get(accounts.size() - 1).getId() + 1;
		}

		return accountId;
	}

}
