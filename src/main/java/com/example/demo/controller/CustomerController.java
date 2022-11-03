package com.example.demo.controller; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
@Autowired	
private CustomerService service;
@GetMapping("/customers")
public ResponseEntity<?> allCustomers(){
	List<Customer> cust=service.getCustomers();
	return new ResponseEntity<List<Customer>>(cust,cust.size()>0?HttpStatus.OK:HttpStatus.NOT_FOUND);
}
@PostMapping("/customers")
public ResponseEntity<?> newCustomer(@RequestBody Customer customer) {
	Customer cust=service.saveCustomer(customer);
	return new ResponseEntity<Customer>(cust,HttpStatus.OK);
}
@GetMapping("/customers/{id}")
public ResponseEntity<?> getCustomerById(@PathVariable int id){
	Optional<Customer> cust=service.findCustomerById(id);
	return new ResponseEntity<Optional<Customer>>(cust,HttpStatus.OK);
}
@PutMapping("/customers/{id}")
public ResponseEntity<?> updateCustomer(@PathVariable int id,@RequestBody Customer customer) {
	service.updateCustomer(customer, id);
	return new ResponseEntity<>("Updated Customer",HttpStatus.OK);
	
}
@DeleteMapping("/customers/{id}")
public ResponseEntity<?> deleteCustomer(@PathVariable int id){
	return new ResponseEntity<>("Deleted Customer"+id,HttpStatus.OK);
}
}
