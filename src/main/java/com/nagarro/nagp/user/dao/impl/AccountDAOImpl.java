package com.nagarro.nagp.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.user.dao.IAccountDAO;
import com.nagarro.nagp.user.model.Account;
import com.nagarro.nagp.user.model.User;

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
	public Account getAccount(String accountNumber) {
		Optional<Account> accountOpt = accounts.stream()
				.filter(a -> a.getAccountNumber().equalsIgnoreCase(accountNumber)).findFirst();
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

	@Override
	public void updateAccount(Account account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equalsIgnoreCase(account.getAccountNumber())) {
				accounts.set(i, account);
				break;
			}
		}
	}

	/**
	 * Gets the new account id.
	 *
	 * @return the new account id
	 */
	private long getNewAccountId() {
		long accountId = 1L;
		if (null != accounts && accounts.size() > 0) {
			accountId = accounts.get(accounts.size() - 1).getId() + 1;
		}

		return accountId;
	}

}
