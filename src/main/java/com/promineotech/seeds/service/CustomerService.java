package com.promineotech.seeds.service;

import java.util.List; 
import java.util.Optional;
import com.promineotech.seeds.entity.Customer;

public interface CustomerService {

  public List<Customer> getCustomers(int customerId);
  
 public Optional<Customer> updateCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email,
      String phone);
  
  public Optional<Customer> deleteCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email,
      String phone);
  
  public Customer addCustomerService(Customer customer);
}


