package com.qa.business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class ServiceTests {
	private JSONUtil util;
	private AccountServiceImplementation service = new AccountServiceImplementation();
	private Account testAccount = new Account("Ian", "Mallinson", "9999");
	private String testAccountJSON;
	private AccountRepository repo = new AccountMapRepository();
	
	@Before
	public void before() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}

	@Test
	public void addAccount() {
		testAccountJSON = util.getJSONForObject(testAccount);
		assertEquals("{\"message\": \"account is blocked\"}", service.createAccount(testAccountJSON));
	}
}
