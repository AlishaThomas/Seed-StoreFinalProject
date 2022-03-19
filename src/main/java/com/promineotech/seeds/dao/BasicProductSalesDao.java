package com.promineotech.seeds.dao;

import java.sql.ResultSet;   
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.seeds.entity.Products;
import com.promineotech.seeds.entity.Seed;
import com.promineotech.seeds.entity.SeedType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicProductSalesDao implements ProductsSalesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Products> getProducts(SeedType seedType, String name) {
    log.info("Dao method is called: seedType={} and name={}", seedType, name);
    String sql = ""
        +"SELECT * "
        +"FROM products "
        +"WHERE name= :name and seed_type= :seed_type";
    
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("seed_type", seedType.toString());
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Products.builder()
            .productId(rs.getInt("product_id"))
            .seedType(SeedType.valueOf(rs.getString("seed_type")))
            .name(rs.getString("name"))
            .price(rs.getFloat("price"))
            .description(rs.getString("description"))
            .build();
      }});
  }
//  

  public List<Seed> getAllSeeds(){
  
  return jdbcTemplate.query("Select * FROM Products",((rs, rowNum) -> Seed
      //@formatter:off
      .builder()
      .seedType(SeedType.valueOf(rs.getString("seed_type")))
      .name(rs.getString("name"))
      .description(rs.getString("description"))
      .price(rs.getBigDecimal(("price")))
      .build())); 
  }
  //@formatter:on

}

