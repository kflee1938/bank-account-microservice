package com.capgemini.bank.account.microservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AccountServiceControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void whenAccountOpened_thenReturnAccountNumber() throws Exception {
		StringBuilder acctInfoBuilder = new StringBuilder();
		acctInfoBuilder.append("{")
				.append("\"firstName\": ").append("\"John\", ")
				.append("\"lastName\": ").append("\"Doe\", ")
				.append("\"dob\": ").append("\"11/11/1998\", ") 
				.append("\"ssn\": ").append("\"123-12-1234\", ") 
				.append("\"email\": ").append("\"john@test.com\", ")
				.append("\"mobileNumber\": ").append("\"123-123-1234\", ")
				.append("\"homeAddress\": ").append("\"123 Main St\", ")
				.append("\"mailingAddress\": ").append("\"123 Main St\", ") 
				.append("\"accountType\": ").append("\"Savings\", ")
				.append("\"balance\" : ").append("\"300.00\"") 
				.append("}");
		mvc.perform(
			post("/open")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(acctInfoBuilder.toString())
		)
			.andExpect(status().isCreated()).andExpect( jsonPath( "$.accountNumber", is("100000000001") ) );
	}

}
