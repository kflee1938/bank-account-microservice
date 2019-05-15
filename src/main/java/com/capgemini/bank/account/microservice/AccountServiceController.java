package com.capgemini.bank.account.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountServiceController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountServiceController.class);
	
	private final AccountRepository repository;
	
	private static long acctNum = 100000000000L;
	
	@Autowired
	AccountServiceController(AccountRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/open")
	public ResponseEntity<Account> openAccount(@RequestBody Account newAccount) {
		
		newAccount.setAccountNumber(getNextAcctNum());
		System.out.println("accountNumber=" + newAccount.getAccountNumber());
		Account createdAccount = repository.save(newAccount);
		return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
		
	}
	
	private static String getNextAcctNum() {
		return Long.toString(++acctNum);
	}
}
