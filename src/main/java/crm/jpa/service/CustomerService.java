package crm.jpa.service;

import java.util.List;
import java.util.Optional;

import crm.jpa.model.Customer;

public interface CustomerService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	Optional<Customer> getCustomerById(Integer id);
	
	/**
	 *
	 * @return
	 */
	List<Customer> getAllCustomers();
	
	/**
	 * Get customers by active status
	 * @param active true or false
	 * @return a list of customers by active status
	 */
	List<Customer> getCustomerByActive(Boolean active);
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	Customer createCustomer(Customer customer);
	
	/**
	 * 
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 
	 * @param customer
	 */
	void deleteCustomer(Customer customer);
}
