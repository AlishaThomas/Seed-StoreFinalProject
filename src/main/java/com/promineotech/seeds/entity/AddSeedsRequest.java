package com.promineotech.seeds.entity;

import java.math.BigDecimal; 
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddSeedsRequest {
    
    private int productId;
    private SeedType seedType;
    private String name;
    private String description;
    private BigDecimal price;
    
  }


