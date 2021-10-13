package com.gowthamrajk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "customername")
	//@NotEmpty(message = "name should not be empty !!!")
	private String customerName;
	
	//@NotEmpty(message = "email should not be empty !!!")
	@Email(regexp = "^[a-z0-9.-]+@[a-zA-Z.-]+$", message = "Invalid email address !!!")
	private String email;
	
	//@Size(min = 10, max = 10, message = "enter valid 10 digit mobile number !!!")
	private long mobile;
	
	//@NotEmpty(message = "password should not be empty !!!")
	@Size(min = 6, max = 15, message = "password should be minimum 6-15 characters !!!")
	private String password;
	
	//@NotEmpty(message = "confirm password should not be empty !!!")
	@Size(min = 6, max = 15)
	@Column(name = "confirmpassword")
	private String confirmPassword;

	public Customer() { }
	
	public Customer(int customerId, String customerName, String email, long mobile,	String password, String confirmPassword) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		
		return "Customer Details => ID : " + customerId + ", Name : " + customerName + ", Email : " + email
				+ ", Mobile : " + mobile + ", Password : " + password + ", Confirm Password : " + confirmPassword;
	}
}
