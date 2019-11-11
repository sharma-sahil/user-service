package com.nagarro.nagp.user.dao;

import java.util.List;

import com.nagarro.nagp.user.model.Account;

/**
 * The Interface IAccountDAO.
 */
public interface IAccountDAO {

	/**
	 * Gets the user accounts.
	 *
	 * @param userId
	 *            the user id
	 * @return the user accounts
	 */
	public List<Account> getUserAccounts(long userId);

	/**
	 * Gets the account.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account
	 */
	public Account getAccount(String accountNumber);

	/**
	 * Creates the account.
	 *
	 * @param account
	 *            the account
	 * @return the account
	 */
	Account createAccount(Account account);

	/**
	 * Update account.
	 *
	 * @param account the account
	 */
	void updateAccount(Account account);

}
