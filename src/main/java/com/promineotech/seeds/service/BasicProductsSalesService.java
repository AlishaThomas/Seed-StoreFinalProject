package com.promineotech.seeds.service;

import java.util.Collections;  
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.seeds.dao.ProductsSalesDao;
import com.promineotech.seeds.entity.Products;
import com.promineotech.seeds.entity.Seed;
import com.promineotech.seeds.entity.SeedType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicProductsSalesService implements ProductsSalesService {
  
  @Autowired
  private ProductsSalesDao productsSalesDao;

  @Transactional(readOnly = true)
  @Override
  public List<Products> getProducts(SeedType seedType, String name) {
    log.info("The getProducts method was called with seedType={} and productId={}",
        seedType, name);
    
    List<Products> products = productsSalesDao.getProducts(seedType, name);
    
    if(products.isEmpty()) {
      String message = String.format("No products found with type or Id", seedType, name);
      throw new NoSuchElementException(message);
    }
    
    Collections.sort(products);
    return products;
    
  }

  
    @Override public List<Seed> getAllSeeds() { 
      return productsSalesDao.getAllSeeds();
    }
   

}

