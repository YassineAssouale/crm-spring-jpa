package crm.jpa.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import crm.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/**
	 * Get customer by lastname
	 * @param lastname
	 * @return the customer
	 */
	Customer findByLastname(String lastname);
	
	/**
	 * Get customer by status
	 * @param active
	 * @return active customers 
	 */
	List<Customer> findByActive(@Param("active") Boolean active);
	
	/**
	 * @return a list of customer with mobil
	 */
	@Query("SELECT c FROM Customer c WHERE c.mobile IS NOT NULL")
	List<Customer> findCustomerWithMobil();
	
	/**
	 * 
	 * @param active
	 * @param pageable
	 * @return a page of active customers 
	 */
	List<Customer> findAllByActive(Boolean active, Pageable pageable);
}
