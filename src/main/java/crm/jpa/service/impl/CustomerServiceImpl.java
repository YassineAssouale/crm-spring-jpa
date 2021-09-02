package crm.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.jpa.exception.DaoException;
import crm.jpa.model.Customer;
import crm.jpa.repository.CustomerRepository;
import crm.jpa.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
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
	@Transactional
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		} catch (DaoException e) {
			logger.error("Erreur de la modification du customer : {}", e.getMessage());
		}

	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		if(getCustomerById(customer.getId()) != null) {
			try {
				customerRepository.delete(customer);
			} catch (DaoException e) {
				logger.error("Erreur de la suppression du customer : {})",e.getMessage());
			}
		}else
			logger.error("Le customer n'existe pas : {}", customer.getId());

	}

}
