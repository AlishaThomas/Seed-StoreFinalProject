package com.promineotech.seeds.controller;
 
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.seeds.entity.Orders;
import com.promineotech.seeds.entity.OrderRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/seedstore/orders")
@OpenAPIDefinition(info = @Info(title = "OrderService"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface OrderController {
  @Operation(
      summary=  "Creates an order.",
      description = "Creates an order.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "An order is created.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = OrderRequest.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to create order.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "A unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      }

)
  
@PostMapping   
@ResponseStatus(code = HttpStatus.CREATED)
public Orders createOrder(@RequestBody OrderRequest orderRequest);
}












