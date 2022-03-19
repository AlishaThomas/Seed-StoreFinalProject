package com.promineotech.seeds.service;

import java.util.NoSuchElementException;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.seeds.dao.OrderDao;
import com.promineotech.seeds.entity.Customer;
import com.promineotech.seeds.entity.OrderProducts;
import com.promineotech.seeds.entity.OrderRequest;
import com.promineotech.seeds.entity.Orders;

@Service
public class BasicOrderService implements OrderService {
  
  @Autowired
  private OrderDao orderDao;
  
  @Transactional
  @Override
  public Orders createOrder(OrderRequest orderRequest) {

    Customer customer = getCustomer(orderRequest);
    OrderProducts orderProducts = getOrderProducts(orderRequest);
    
    return orderDao.saveOrder(customer, orderProducts);
  }

  private OrderProducts getOrderProducts(OrderRequest orderRequest) {
    return orderDao.getOrderProducts(orderRequest.getProductId());
  }


  private Customer getCustomer(OrderRequest orderRequest) {
    return orderDao.getCustomer(orderRequest.getCustomer())
        .orElseThrow(()-> new NoSuchElementException("Customer was not found."));
  }
  
  
}
