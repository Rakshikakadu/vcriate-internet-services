package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.CustomerException;
import com.vcriate.RestaurantManagementSystem.Model.Customer;

public interface CustomerService {
	 List<Customer> getAllCustomers();
	    Customer getCustomerById(Long id) throws CustomerException;
	    Customer createCustomer(Customer customer);
	    Customer updateCustomer(Long id, Customer customer) throws CustomerException;
	    void deleteCustomer(Long id) throws CustomerException;

}
