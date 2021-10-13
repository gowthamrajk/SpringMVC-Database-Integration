package com.gowthamrajk.repository;

import java.util.List;
import com.gowthamrajk.model.Customer;

public interface CustomerRepositoryInterface {

	public void addNewCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId) ;
	
	public List<Customer> getAllCustomer();
	
}
