package com.promineotech.seeds.entity;

import lombok.Builder; 
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Seed {
  
  private SeedType seedType;
  private String name;
  private BigDecimal price;
  private String description;
  
}
