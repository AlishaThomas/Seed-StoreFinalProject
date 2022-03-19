package com.promineotech.seeds.entity;
 
import java.util.Date; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class OrderRequest {

  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]+")
  private String customer;
  
  @Positive
  @NotNull
  private int productId;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]+")
  private SeedType seedType;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]+")
  private String name;
    
  @NotNull
  @Positive
  private int price;
  
  @NotNull
  private Date orderDate;
  
  
  
 
}
