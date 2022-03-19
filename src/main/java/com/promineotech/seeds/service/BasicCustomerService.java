package com.promineotech.seeds.service;

import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.seeds.dao.CustomerDao;
import com.promineotech.seeds.entity.Customer;

@Service
public class BasicCustomerService implements CustomerService {

  @Autowired
  private CustomerDao customerDao;
  
  @Override
  public List<Customer> getCustomers(int customerId) {
    return customerDao.getCustomers(customerId);
  }


  @Override
  public Optional<Customer> updateCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email, String phone) {
    return customerDao.updateCustomers(customer_id, first_name, last_name, street, city, state, zip, email, phone);
  }

  @Override
  public Optional<Customer> deleteCustomers(int customer_id, String first_name, String last_name,
      String street, String city, String state, String zip, String email, String phone) {
    return customerDao.deleteCustomers(customer_id, first_name, last_name, street, city, state, zip, email, phone);
  }



  @Override
  public Customer addCustomerService(Customer customer) {
    // TODO Auto-generated method stub
    return customerDao.createCustomer(customer);
  }




}

