package com.capgemini.bank.account.microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void whenSaved_thenFindByAccountNumber() throws ParseException {
		String accountNumber = "100000000001";
		accountRepository.save( new Account(
				accountNumber, "John", "Doe", new SimpleDateFormat("MM/dd/yyyy").parse("11/11/1998"), 
				"123-12-1234", 
	    		"john@test.com", "123-123-1234", "123 Main St", "123 Main St", 
	    		"Savings", new BigDecimal("300.00")
				)		
			);
		Account actual = accountRepository.findByAccountNumber(accountNumber);
		System.out.println("Id=" + actual.getId());
		assertThat(actual).isNotNull();
	}
	
	@Test
	public void whenFindByAccountNumber_thenReturnAccount() {
		//fail("Not yet implemented");
	}

}
