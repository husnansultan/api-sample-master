package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.*;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private AccountService service;
	
	@Path("/json")
	@GET
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/json/{id}")
	@DELETE
	public String deleteAccount(@PathParam("id") int id) {
		return service.deleteAccount(id);
	}

	@Path("/json/{id}")
	@PUT
	public String updateAccount(@PathParam("id") int id, String account) {
		return service.updateAccount(id, account);
	}
	
	public void setService(AccountService service) {
		this.service = service;
	}
}
