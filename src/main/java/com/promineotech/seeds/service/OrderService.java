package com.promineotech.seeds.service;

import com.promineotech.seeds.entity.Orders;   
import com.promineotech.seeds.entity.OrderRequest;

public interface OrderService {

  Orders createOrder(OrderRequest orderRequest);
  
}

