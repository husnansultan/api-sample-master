package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{

	private HashMap<Integer, com.qa.persistence.domain.Account> accounts = new HashMap<>();
	
	private JSONUtil json = new JSONUtil();

	public Account getmyAccount(int accountNumber) {
		return accounts.get(accountNumber);

	}

	public int searchAccounts(String firstName) {

		List<Account> newlist = (accounts.values().stream()
				.filter(a -> a.getFirstName() == firstName)
				.collect(Collectors.toList()));
		return newlist.size();

	}

	@Override
	public String getAllAccounts() {
		
		return json.getJSONForObject(accounts);
	}

	@Override
	public String createAccount(String accout) {
		Account anAccount = util.getObjectForJSON(accout, Account.class);
		return null;
	}

	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
