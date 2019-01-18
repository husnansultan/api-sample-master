package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import javax.transaction.Transactional;

import com.qa.persistance.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountDBRepositoryMap implements AccountRepository {
	
	
	@Inject
	private JSONUtil util;
	@Inject
	private HashMap<Long, Account> accounts;
	

	public String getAllAccounts() {
		 return util.getJSONForObject(accounts);
	}

	
	public String createAccount(String accountJSON) {
		Account newAccount = util.getObjectForJSON(accountJSON, Account.class);
		accounts.put( newAccount.getId(),newAccount);
		return "{\"message\": \"account sucessfully created\"}";
		
	}
	
	
	public String updateAccount(Long id, String accountJSON) {
		Account accountInDB = accounts.get(id);
		Account newAccount = util.getObjectForJSON(accountJSON, Account.class);

		if(accountInDB != null) {
			accountInDB.setFirstName(newAccount.getFirstName());
			accountInDB.setLastName(newAccount.getLastName());	
			accountInDB.setAccountNumber(newAccount.getAccountNumber());		
			return "{\"message\": \"has been sucessfully updated\"}";
		}
	
		// TODO Auto-generated method stub
		return"{\"message\": \"The account number is invalid\"}";
	}
	

	public String deleteAccount(Long id) {
		Account accountInDB = accounts.get(id);
		if (accountInDB != null) {
			accounts.remove(id);
			return "{\"message\": \"account sucessfully deleted\"}";
			}
		return "{\"message\": \"deletion did not work\"}";
	
	}
	

}
