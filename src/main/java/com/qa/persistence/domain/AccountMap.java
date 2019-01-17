package com.qa.persistence.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountMap {
	private static final AccountMap INSTANCE = new AccountMap();
	private Map<Integer, Account> accounts = new HashMap<>();


	private AccountMap() {
		
	}

	public static AccountMap getInstance() {
		return INSTANCE;
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

}