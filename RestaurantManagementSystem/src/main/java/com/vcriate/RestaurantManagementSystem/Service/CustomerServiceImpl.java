package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.CustomerException;
import com.vcriate.RestaurantManagementSystem.Model.Customer;
import com.vcriate.RestaurantManagementSystem.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) throws CustomerException {
		return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
   
	}

	@Override
	public Customer createCustomer(Customer customer) {
		 return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) throws CustomerException {
		Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
        
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        
        return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(Long id) throws CustomerException {
		Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
        
        customerRepository.delete(existingCustomer);
		
	}

}
