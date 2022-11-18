package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repo;
	@Override
	public List<Customer> getCustomers() {
		return repo.findAll();
	}

	@Override
	@Cacheable(value="customers",key="#id")
	public Customer findCustomerById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		repo.save(customer);
		return customer;
	}

	@Override
	@CacheEvict(value="customers",key="#id")
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}

	@Override
	@CachePut(value="customers",key="#id")
	public Customer updateCustomer(Customer customer, int id) {
		Optional<Customer> cust=repo.findById(id);
		if(cust.isPresent()) {
			repo.deleteById(id);
		}
		repo.save(customer);
		return customer;
		
	}

}
