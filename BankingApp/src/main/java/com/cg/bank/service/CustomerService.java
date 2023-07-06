package com.cg.bank.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bank.entity.Customer;
import com.cg.bank.repository.CustomerRepository;

@org.springframework.stereotype.Service
public class CustomerService {
	@Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        // Implement customer creation logic
        // You can perform validations, generate unique IDs, etc.
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        // Implement logic to retrieve a customer by ID
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public Customer updateCustomer(Long id, Customer customer) {
        // Implement logic to update a customer
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        // Update other fields as needed

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        // Implement logic to delete a customer
        customerRepository.deleteById(id);
    }
}
