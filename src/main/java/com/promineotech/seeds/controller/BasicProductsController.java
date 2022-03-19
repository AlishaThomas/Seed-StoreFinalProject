package com.promineotech.seeds.controller;

import java.util.List;     
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.seeds.entity.Products;
import com.promineotech.seeds.entity.Seed;
import com.promineotech.seeds.entity.SeedType;
import com.promineotech.seeds.service.ProductsSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicProductsController implements ProductsController {

  @Autowired
  private ProductsSalesService productsSalesService;
  
  @Override
  public List<Products> getSeeds(SeedType seedType, String name) {
    log.debug("seedType={}, productId={}", seedType, name);
    return productsSalesService.getProducts(seedType, name);
  }

  @Override
  public List<Seed> getAllSeeds() {
    
    return productsSalesService.getAllSeeds();
  }


}
