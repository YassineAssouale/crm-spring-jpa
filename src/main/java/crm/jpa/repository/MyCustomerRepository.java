package crm.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import crm.jpa.model.Customer;

public interface MyCustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByLastname(String lastname);
	
	Customer findByActive(@Param("active") Boolean active);
	
	@Query("SELECT c FROM Customer WHERE c.mobile IS NOT NULL")
	List<Customer> findCustomerWithMobile();
	
	Page<Customer> findAllByActive(Boolean active, Pageable page);
}
