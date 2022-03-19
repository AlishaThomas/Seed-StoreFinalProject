package com.promineotech.seeds.controller;

import com.promineotech.seeds.entity.Orders;
import com.promineotech.seeds.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.seeds.entity.OrderRequest;

@RestController
public class BasicOrderController implements OrderController{

  
  @Autowired
  private OrderService orderService;
  
  @Override
  public Orders createOrder(OrderRequest orderRequest) {
    return orderService.createOrder(orderRequest);
  }
}
