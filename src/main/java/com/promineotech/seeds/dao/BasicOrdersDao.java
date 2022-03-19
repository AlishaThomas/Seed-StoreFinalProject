package com.promineotech.seeds.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.seeds.entity.Customer;
import com.promineotech.seeds.entity.OrderProducts;
import com.promineotech.seeds.entity.Orders;
import com.promineotech.seeds.entity.Products;

@Component
public class BasicOrdersDao implements OrderDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public Orders saveOrder(Customer customer, OrderProducts orderProducts) {
    
    SqlParams params = generateInsertSql(customer, orderProducts);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    
    return Orders.builder()
        .orderPK(orderPK)
        .customerFK(customer)
        .productsFK(orderProducts)
        .build();    
    
  }
 
  private SqlParams generateInsertSql(Customer customer, OrderProducts orderProducts) {
  SqlParams params = new SqlParams();
  
  params.sql = ""
      +"INSERT INTO orders ("
      +"customer_fk, products_fk, order_total"
      +") VALUES ("
      +":customer_fk, :products_fk, order_total"
      +")";
    
   params.source.addValue("customer_fk", customer.getCustomer_id());
   params.source.addValue("products_fk", orderProducts.getProductId());
   
    return params;
  }


  @Override
  public Optional<Customer> getCustomer(String customer_id) {
    String sql = ""
    +"SELECT * "
    +"FROM customers "
    +"WHERE customer_id = :customer_id";
    
    
   Map<String, Object> params = new HashMap<>();
   params.put("customer_id", customer_id);
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
      }
      
      class CustomerResultSetExtractor implements ResultSetExtractor<Customer>{
        
       @Override
      public Customer extractData(ResultSet rs) 
          throws SQLException, DataAccessException {
         rs.next();
        return Customer.builder()
            .customer_id(rs.getInt("customer_id"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .street(rs.getString("street"))
            .city(rs.getString("city"))
            .state(rs.getString("state"))
            .zip(rs.getString("zip"))
            .email(rs.getString("email"))
            .phone(rs.getString("phone"))
            .build();
       } 
    
  }

      @Override
      public Products getProducts(int productId) {
        String sql = ""
            +"SELECT * "
            +"FROM products "
            +"WHERE product_id= :product_id";
            
            
           Map<String, Object> params = new HashMap<>();
           params.put("product_id", productId);
            return jdbcTemplate.query(sql, params, new ProductsResultSetExtractor());
              }
              
              class ProductsResultSetExtractor implements ResultSetExtractor<Products>{
                
               @Override
              public Products extractData(ResultSet rs) 
                  throws SQLException, DataAccessException {
                 rs.next();
                return Products.builder()
                    .productId(rs.getInt("products_id"))
                    .name(rs.getString("name"))
                    .price(rs.getFloat("price"))
                    .build();            
      }

}

  @Override
  public OrderProducts getOrderProducts(int productId) {
  
       Map<String, Object> params = new HashMap<>();  
       
       String sql = ""
        +"SELECT * "
        +"FROM order_products "
        +"WHERE products_id= :products_id";
       
       params.put("products_id", productId);
       
        return jdbcTemplate.query(sql, params, new OrderProductsResultSetExtractor());
          }
          
          class OrderProductsResultSetExtractor implements ResultSetExtractor<OrderProducts>{
            
           @Override
          public OrderProducts extractData(ResultSet rs) 
              throws SQLException, DataAccessException {
             rs.next();
            return OrderProducts.builder()
                .productId(rs.getInt("products_id"))
                .build();
           }
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}

