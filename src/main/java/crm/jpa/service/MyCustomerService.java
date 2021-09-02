package crm.jpa.service;

import java.util.List;
import java.util.Optional;

import crm.jpa.model.Customer;

public interface MyCustomerService {
	
	Optional<Customer> getCustomerById(Integer id);
	
	List<Customer> getAllCustomers();
	
	List<Customer> getCustomerByActive(Boolean active);
	
	Customer createCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);

}
