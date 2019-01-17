package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.AccountMap;

public class MapTests {
	private AccountRepository accounts;
	private Account testAccount;
	
	@Before
	public void before() {
		accounts = new AccountMapRepository();
		AccountMap.getInstance().setAccounts(new HashMap<>());
		testAccount = new Account("Ian", "Mallinson", "1");
	}
	
	@Test
	public void addAccountTest() {
		assertEquals("{\"message\": \"account has been sucessfully added\"}", accounts.createAccount(testAccount));
	}
	
	@Test
	public void getAccountsTest() {
		accounts.createAccount(testAccount);
		assertEquals("{\"1\":{\"firstName\":\"Ian\",\"lastName\":\"Mallinson\",\"accountNumber\":\"1\"}}", accounts.getAllAccounts());
	}
	
	@Test
	public void deleteAccountTest() {
		accounts.createAccount(testAccount);
		assertEquals("{\"message\": \"account has been sucessfully deleted\"}", accounts.deleteAccount(1));
		assertEquals("{}" ,accounts.getAllAccounts());
	}
	
	@Test
	public void deleteAccountNotExistingTest() {
		assertEquals("{\"message\": \"account does not exist\"}", accounts.deleteAccount(1));
	}
	
	@Test
	public void updateAccountTest() {
		accounts.createAccount(testAccount);
		testAccount.setFirstName("Bob");
		assertEquals("{\"message\": \"account has been sucessfully updated\"}", accounts.updateAccount(1, testAccount));
		assertEquals("{\"1\":{\"firstName\":\"Bob\",\"lastName\":\"Mallinson\",\"accountNumber\":\"1\"}}", accounts.getAllAccounts());
	}
	
	@Test
	public void updateAccountNotExistingTest() {
		assertEquals("{\"message\": \"account does not exist\"}", accounts.updateAccount(1, testAccount));
	}
}
