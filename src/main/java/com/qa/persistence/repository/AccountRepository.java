package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {
	String getAllAccounts();

	String createAccount(Account account);

	String deleteAccount(int id);
	
	String updateAccount(int id, Account account);
}
