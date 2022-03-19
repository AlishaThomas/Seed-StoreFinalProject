package com.promineotech.seeds.entity;

import lombok.Builder;   
import lombok.Data;

@Data
@Builder
public class OrderProducts {

  private int orderProductsId;
  private int orderId;
  private int productId;
  
}
