package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<Customer> findCustomerById(int id) {
		return repo.findById(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		repo.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer, int id) {
		Optional<Customer> cust=repo.findById(id);
		if(cust.isPresent()) {
			repo.deleteById(id);
		}
		repo.save(customer);
		
	}

}
