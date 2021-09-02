package crm.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import crm.jpa.exception.DaoException;
import crm.jpa.model.Customer;
import crm.jpa.repository.CustomerRepository;
import crm.jpa.service.MyCustomerService;

public class MyCustomerServiceImpl implements MyCustomerService{

	Logger logger = org.slf4j.LoggerFactory.getLogger(MyCustomerServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Optional<Customer> getCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> getCustomerByActive(Boolean active) {
		return customerRepository.findByActive(active);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		} catch (DaoException e) {
			logger.error("Error when updating customer : {}", e.getMessage());
		}
		
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		if(getCustomerById(customer.getId()) != null) {
			try {
				customerRepository.delete(customer);
			} catch (DaoException e) {
				logger.error("Error when deleting customer : {}", e.getMessage());
			}
		}else
			logger.error("Customer not found : {}", customer.getId());		
	}
}
