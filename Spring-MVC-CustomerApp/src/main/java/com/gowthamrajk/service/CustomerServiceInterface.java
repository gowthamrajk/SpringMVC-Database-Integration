package com.gowthamrajk.service;

import java.util.List;
import com.gowthamrajk.model.Customer;

public interface CustomerServiceInterface {
	
	public void addNewCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
	public Customer getCustomerById(int customerId);
	
	public List<Customer> getAllCustomers();

}
