package com.gowthamrajk.repository;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gowthamrajk.model.Customer;

@Transactional
@Repository
public class CustomerRepository {

	public static final Logger logger = Logger.getLogger(CustomerRepository.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addNewCustomer(Customer customer) {

		logger.trace("New customer added to the database");
		hibernateTemplate.persist(customer);
	}

	public void updateCustomer(Customer customer) {

			hibernateTemplate.update(customer);
	}

	public void deleteCustomer(Customer customer) {

			hibernateTemplate.delete(customer);
	}

	public Customer getCustomerById(int customerId) {

		return hibernateTemplate.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomer() {

		return hibernateTemplate.loadAll(Customer.class);
	}

}