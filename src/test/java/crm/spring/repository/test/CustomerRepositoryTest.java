package crm.spring.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import crm.jpa.config.AppConfig;
import crm.jpa.model.Customer;
import crm.jpa.repository.CustomerRepository;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void testGetAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		assertEquals(4, customers.size());
	}


	@Test
	void testGetCustomersByActive() { 
		List<Customer> customers = customerRepository.findByActive(true); 
		assertEquals(2,customers.size()); 
	}

	@Test
	void testGetCustomersWithMobile() { 
		List<Customer> customers = customerRepository.findCustomerWithMobil(); 
		customers.forEach(c -> assertNotNull(c.getMobile())); 
	}


	@Test
	void testCreate() {
		Customer newCustomer = new Customer();
		newCustomer.setFirstname("Winnie");
		newCustomer.setLastname("L'Ourson");
		newCustomer.setCompany("Disney");
		newCustomer.setPhone("0222222222");
		newCustomer.setMobile("0666666666");
		newCustomer.setMail("winnie.l.ourson@disney.com");
		newCustomer.setNotes("Les notes de Winnie");
		newCustomer.setActive(true);

		customerRepository.save(newCustomer);

		Customer customer = customerRepository.findByLastname("L'Ourson");
		Assertions.assertNotNull(customer, "Winnie not found");
	}

	@Test
	void testUpdate() {
		Customer customer = customerRepository.findByLastname("GILBERT");
		customer.setCompany("Nouvelle entreprise");

		customerRepository.save(customer);

		Customer updatedCustomer = customerRepository.findByLastname("GILBERT");
		Assertions.assertEquals("Nouvelle entreprise", updatedCustomer.getCompany());
	}

	@Test
	void testDelete() {
		Optional<Customer> customer = customerRepository.findById(2);
		if(customer.isEmpty()) {
			fail();
		}
		customerRepository.delete(customer.get());

		Optional<Customer> deletedCustomer = customerRepository.findById(2);
		Assertions.assertTrue(deletedCustomer.isEmpty(), "Deleted customer must be null");

	}
	/**** Pagination ****/
	@Test
	void testfindAllByActive() {
		Pageable pagingCustomer = PageRequest.of(0,1);
		Page<Customer> customerPage1 = (Page<Customer>) customerRepository.findAllByActive(true, pagingCustomer);
		System.out.println("Pagination Customers : N° de page = " + customerPage1.getNumber() 
		+ ", Nombre d'éléments sur page = " + customerPage1.getNumberOfElements() 
		+ ", NB total éléments = " + customerPage1.getTotalElements()
		+ ", nb total pages " + customerPage1.getTotalPages());

		assertEquals(1, customerPage1.getNumberOfElements());

		Pageable pagingCustomer2 = PageRequest.of(1,1);
		Page<Customer> customerPage2 = (Page<Customer>) customerRepository.findAllByActive(true, pagingCustomer2);
		System.out.println("Pagination Customers : N° de page = " + customerPage2.getNumber() 
		+ ", Nombre d'éléments sur page = " + customerPage2.getNumberOfElements() 
		+ ", NB total éléments = " + customerPage2.getTotalElements()
		+ ", nb total pages " + customerPage2.getTotalPages());

		assertEquals(1, customerPage2.getNumberOfElements());


	}
}
