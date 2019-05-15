package com.capgemini.bank.account.microservice;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@NotBlank
	@Size(max=12)
	@Column(nullable = false)
	private String accountNumber;
	
	@NotBlank(message="First name is required")
    @Size(max=30)
	@Column(nullable = false)
	private String firstName; 

    @NotBlank(message="Last name is required")
    @Size(max=30)
	@Column(nullable = false)
    private String lastName;
    
    @NotNull(message="DOB is requried")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Past(message="DOB cannot be in the future")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
    private Date dob;
    
    //@NotBlank(message="SSN is required")
    @Pattern(regexp="\\d{3}-\\d{2}-\\d{4}", message="Please enter SSN in this format: ###-##-####")
	@Column(nullable = false)
    private String ssn;
    
    @NotBlank(message="Email address is required")
    @Email(message="Please enter a valid email address")
	@Column(nullable = false)
    private String email; 
    
    @Pattern(regexp="\\d{3}-\\d{3}-\\d{4}", message="Please enter mobile number in this format: ###-###-####")
	@Column(nullable = false)
    private String mobileNumber;
    
    @NotBlank(message="Home address is required")
    @Size(max=100)
	@Column(nullable = false)
    private String homeAddress; 

    @NotBlank(message="Mailing address is required")
    @Size(max=100)
	@Column(nullable = false)
    private String mailingAddress;

    @NotBlank(message="Please select an account type")
	@Column(nullable = false)
    private String accountType;
    
    @NotNull(message="Minimum balance is required")
    @Digits(fraction=2, message="Please enter the minimum balance in this format: ###.##", integer = 6)
    @Positive
    private BigDecimal balance;
    
    public Account() {}
    
    public Account(String accountNumber, String firstName, String lastName, Date dob, String ssn, 
    		String email, String mobileNumber, String homeAddress, String mailingAddress, 
    		String accountType, BigDecimal balance) {
    	
    	this.accountNumber = accountNumber;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dob = dob;
    	this.ssn = ssn;
    	this.email = email;
    	this.mobileNumber = mobileNumber;
    	this.homeAddress = homeAddress;
    	this.mailingAddress = mailingAddress;
    	this.accountType = accountType;
    	this.balance = balance;
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
