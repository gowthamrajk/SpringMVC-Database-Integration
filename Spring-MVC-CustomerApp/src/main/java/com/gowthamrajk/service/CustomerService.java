package com.gowthamrajk.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gowthamrajk.model.Customer;
import com.gowthamrajk.repository.CustomerRepository;

@Service
public class CustomerService {

	public static final Logger logger = Logger.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	public void addNewCustomer(Customer customer) {
		
		for(Customer customerObj : customerRepository.getAllCustomer()) {
			if(customerObj.equals(customer)) {
				logger.trace("Already present !!!");
				break;
			}
		}
		customerRepository.addNewCustomer(customer);
		logger.trace("customer repo called");
	}
	
	public void updateCustomer(Customer customer) {
		
		customerRepository.updateCustomer(customer);
	}
	
	public void deleteCustomer(int customerId) {
		
		customerRepository.deleteCustomer(getCustomerById(customerId));
	}
	
	public Customer validateCustomer(Customer customer) {
		
		for(Customer customerObj : getAllCustomers()) {
			
			if(customer.getEmail().equals(customerObj.getEmail())) 
				return customerObj;
		}
		return null;
	}
	
	public Customer getCustomerById(int customerId) {
		
		return customerRepository.getCustomerById(customerId);
	}
	
	public List<Customer> getAllCustomers() {
		
		return customerRepository.getAllCustomer();
	}
	
	public Customer getCustomerProfile(String customerName) {
		
		for(Customer customerObj : getAllCustomers()) {
			
			if(customerObj.getCustomerName().equals(customerName)) 
				return customerObj;
		}
		return null;
	}
	
	public boolean findCustomerPresence(Customer customer) {
		
		for(Customer customerObj : getAllCustomers()) {
			
			if(customerObj.equals(customer))
				return true;
		}
		return false;
	}
	
}