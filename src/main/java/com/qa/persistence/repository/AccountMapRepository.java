package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED; 
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.AccountMap;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountMapRepository implements AccountRepository {
	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(AccountMap.getInstance().getAccounts());
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(Account account) {
		AccountMap.getInstance().getAccounts().put(Integer.parseInt(account.getAccountNumber()), account);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int id) {
		if (AccountMap.getInstance().getAccounts().containsKey(id)) {
			AccountMap.getInstance().getAccounts().remove(id);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(int id, Account account) {
		if (AccountMap.getInstance().getAccounts().containsKey(id)) {
			AccountMap.getInstance().getAccounts().remove(id);
			AccountMap.getInstance().getAccounts().put(id, account);
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}
}
