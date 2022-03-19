package com.promineotech.seeds.entity;

import com.fasterxml.jackson.annotation.JsonIgnore; 
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

  @JsonIgnore
  private int customer_id; 
  private String first_name;
  private String last_name;
  private String street; 
  private String city; 
  private String state; 
  private String zip;
  private String email;
  private String phone;
}
