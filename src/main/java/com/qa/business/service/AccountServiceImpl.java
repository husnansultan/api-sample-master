package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Account;
import com.qa.persistance.repository.AccountRepository;
import com.qa.util.JSONUtil;


public class AccountServiceImpl implements AccountService {
	
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;

	
	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.getAllAccounts();
	}

	public String createAccount(String accountJSON) {
		if ((util.getObjectForJSON(accountJSON, Account.class).getAccountNumber() == 9999)) {
			return "{\"message\": \"account is blocked\"}";			
		}
		else {
		return repo.createAccount(accountJSON);
		}
	}
	
	public String updateAccount(Long id, String accountJSON) {
		// TODO Auto-generated method stub
		return repo.updateAccount(id,accountJSON);
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteAccount(id);
	}
	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}


}
