package com.qa.persistance.repository;

public interface AccountRepository {
	
	String getAllAccounts();
	String createAccount(String accountJSON);
	String updateAccount(Long id, String accountJSON);
	String deleteAccount(Long id);

}
