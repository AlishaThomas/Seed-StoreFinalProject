package com.promineotech.seeds.dao;

import java.util.List; 
import java.util.Optional;
import com.promineotech.seeds.entity.Customer;

public interface CustomerDao {

  List<Customer> getCustomers(int customerId);
  
  public Customer createCustomer(Customer customer);
    
  Optional<Customer> updateCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email,
      String phone);
  
  Optional<Customer> deleteCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email,
      String phone);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
