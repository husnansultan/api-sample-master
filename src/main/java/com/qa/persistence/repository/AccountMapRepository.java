package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Integer, com.qa.persistence.domain.Account> accounts = new HashMap<>();

	private JSONUtil json = new JSONUtil();

	@Override
	public String getAllAccounts() {
		return json.getJSONForObject(accounts);
	}


	@Override
	public String updateAccount(Long id, String accout) {
		
		return null;
	}
	
	public Account getmyAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}

	public int searchAccounts(String firstName) {
		List<Account> newlist = (accounts.values().stream().filter(a -> a.getFirstName() == firstName)
				.collect(Collectors.toList()));
		return newlist.size();
	}


	@Override
	public String createAccount(String accout) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
