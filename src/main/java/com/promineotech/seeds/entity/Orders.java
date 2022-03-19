package com.promineotech.seeds.entity;


import java.util.Date;   
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

  private Long orderPK;
  private Customer customerFK;
  private OrderProducts productsFK;
  private double order_total;
  private Date order_date; // Can be used to return Date to customer
  
}
