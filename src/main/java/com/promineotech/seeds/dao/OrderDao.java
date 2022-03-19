package com.promineotech.seeds.dao;
 
import java.util.Optional;  
import com.promineotech.seeds.entity.Customer;
import com.promineotech.seeds.entity.OrderProducts;
import com.promineotech.seeds.entity.Orders;
import com.promineotech.seeds.entity.Products;

public interface OrderDao {

  Optional<Customer> getCustomer(String customer);
  
  OrderProducts getOrderProducts(int orderProductId);
  
  Products getProducts(int productId);
  
  Orders saveOrder(Customer customer, OrderProducts orderProducts);

 
  
  

  



  
}

