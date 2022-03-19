package com.promineotech.seeds.service;

import java.util.List;  
import com.promineotech.seeds.entity.Products;
import com.promineotech.seeds.entity.Seed;
import com.promineotech.seeds.entity.SeedType;

public interface ProductsSalesService {

  public List<Products> getProducts(SeedType seedType, String name);
  
  public List<Seed> getAllSeeds();
}
