package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Optional<Customer> findCustomerById(int id);
	public Customer saveCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(Customer customer,int id);
}
