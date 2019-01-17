package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {
	@Inject
	AccountRepository repo;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String accountJSON) {
		Account account = util.getObjectForJSON(accountJSON, Account.class);
		if (account.getAccountNumber().equals("9999")) {
			return "{\"message\": \"account is blocked\"}";			
		}
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(int id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(int id, String accountJSON) {
		Account account = util.getObjectForJSON(accountJSON, Account.class);
		return repo.updateAccount(id, account);
	}
	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}