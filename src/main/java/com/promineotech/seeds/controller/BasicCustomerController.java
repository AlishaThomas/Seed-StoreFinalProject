package com.promineotech.seeds.controller;

import java.util.List;   
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.seeds.entity.Customer;
import com.promineotech.seeds.service.CustomerService;

@RestController
public class BasicCustomerController implements CustomerController {

  @Autowired
  private CustomerService customerService;
  
  @Override
  public List<Customer> getCustomers(int customer_id, String first_name, String last_name) {
    return customerService.getCustomers(customer_id);
  }

  @Override
  public Optional<Customer> updateCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email, String phone) {
    return customerService.updateCustomers(customer_id, first_name, last_name, street, city, state, zip, email, phone);
  }

  @Override
  public Optional<Customer> deleteCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email, String phone) {
    return customerService.deleteCustomers(customer_id, first_name, last_name, street, city, state, zip, email, phone);
  }



  @Override
  public Customer addCustomers(Customer customer) {
    return customerService.addCustomerService(customer);
  }

}
