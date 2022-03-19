package com.promineotech.seeds.entity;

import java.util.Comparator;   
import com.fasterxml.jackson.annotation.JsonIgnore; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Comparable<Products>{

  private int productPK;
  private int productId;
  private SeedType seedType;
  private String name;
  private Float price;
  private String description;
  
  
   @JsonIgnore 
   public int getProductPK(){ 
     return productPK; 
   }
    
    @Override public int compareTo(Products that) { return
    Comparator.comparing(Products::getProductId) .thenComparing(Products::getSeedType)
    .compare(this, that); }
   
}
