package com.qa.persistence.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBTests {
	@InjectMocks
	private AccountDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;
	
	@Inject
	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"1234\"}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"1234\"}";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		repo.setUtil(util);
	}

	@Test
	public void addAccountTest() {
		fail("not implemented");
	}

	@Test
	public void getAccountsTest() {
		fail("not implemented");
	}

	@Test
	public void deleteAccountTest() {
		fail("not implemented");
	}

	@Test
	public void deleteAccountNotExistingTest() {
		fail("not implemented");
	}

	@Test
	public void updateAccountTest() {
		fail("not implemented");
	}

	@Test
	public void updateAccountNotExistingTest() {
		fail("not implemented");
	}
}
