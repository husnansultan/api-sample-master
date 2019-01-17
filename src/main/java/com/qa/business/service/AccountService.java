package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface AccountService {

	public String getAllAccounts();

	public String createAccount(String accountJSON);

	public String deleteAccount(int id);
	
	public String updateAccount(int id, String accountJSON);

}
