package com.promineotech.seeds.dao;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.seeds.entity.Customer;
import org.springframework.jdbc.support.*;

@Component
public class BasicCustomerDao implements CustomerDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Customer createCustomer(Customer customer) {
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    SqlParams params = generateInsertCustomer(customer);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    
    return Customer.builder()
        .customer_id(customer.getCustomer_id())
        .first_name(customer.getFirst_name())
        .last_name(customer.getLast_name())
        .street(customer.getState())
        .city(customer.getCity())
        .state(customer.getState())
        .zip(customer.getZip())
        .email(customer.getEmail())
        .phone(customer.getPhone())
        .build();
  }
  
  /**
   * @param customer
   * @return
   */
  private SqlParams generateInsertCustomer(Customer customer) {
    SqlParams params = new SqlParams();
    
    params.sql = ""
        +"INSERT INTO customers "
        +"(customer_id, first_name, last_name, street, city, state, zip, email, phone) "
        +"Values(:customer_id, :first_name, :last_name, :street, :city, :state, :email, :zip, :phone)";
   
    params.source.addValue("customer_id", customer.getCustomer_id());
    params.source.addValue("first_name", customer.getFirst_name());
    params.source.addValue("last_name", customer.getLast_name());
    params.source.addValue("street", customer.getStreet());
    params.source.addValue("city", customer.getCity());
    params.source.addValue("state", customer.getState());
    params.source.addValue("zip", customer.getZip());
    params.source.addValue("email", customer.getEmail());
    params.source.addValue("phone", customer.getPhone());
    
    return params;
  }

  @Override
  public List<Customer> getCustomers(int customer_id) {
    String sql =""
        +"SELECT * "
        +"FROM customers "
        +"WHERE customer_id= :customer_id";
    
    Map<String,Object> params = new HashMap<>();
    params.put("customer_id", customer_id);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>(){
      
   public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
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
        
         }}); 
    }
  

  @Override
  public Optional<Customer> updateCustomers(int customer_id, String first_name, String last_name, String street,
      String city, String state, String zip, String email, String phone) {
    // TODO Auto-generated method stub
    
    String sql = ""
        +"UPDATE customers "
        +"SET first_name= :new_first_name, "
        +"last_name= :new_last_name, "
        +"street= :new_street, "
        +"city= :new_city, "
        +"state= :new_state, "
        +"zip= :new_zip, "
        +"email= :new_email, "
        +"phone= :new_phone "
        +"WHERE customer_id= :customer_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customer_id);
    params.put("first_name", first_name);
    params.put("last_name", last_name);
    params.put("street", street);
    params.put("city", city);
    params.put("state", state);
    params.put("zip", zip);
    params.put("email", email);
    params.put("phone", phone);
    params.put("new_first_name", first_name);
    params.put("new_last_name", last_name);
    params.put("new_street", street);
    params.put("new_city", city);
    params.put("new_state", state);
    params.put("new_zip", zip);
    params.put("new_email", email);
    params.put("new_phone", phone);

    
    
    jdbcTemplate.update(sql, params);   
    return Optional.ofNullable(Customer.builder()
        .customer_id(customer_id)
        .first_name(first_name)
        .last_name(last_name)
        .street(street)
        .city(city)
        .state(state)
        .zip(zip)
        .email(email)
        .phone(phone)
        .build());
  }

  @Override
  public Optional<Customer> deleteCustomers(int customer_id, String first_name, String last_name, String street,
      String city, String state, String zip, String email, String phone) {
    String sql = ""
        +"Delete from customers "
        +"Where customer_Id= :customer_id ";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customer_id);
   
    
    
    jdbcTemplate.update(sql, params);   
    return Optional.ofNullable(Customer.builder()
        .customer_id(customer_id)
        .first_name(first_name)
        .last_name(last_name)
        .street(street)
        .city(city)
        .state(state)
        .zip(zip)
        .email(email)
        .phone(phone)
        .build());
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
}

