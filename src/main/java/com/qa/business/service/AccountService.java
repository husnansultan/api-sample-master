package com.qa.business.service;

public interface AccountService {

	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(Long id);

}