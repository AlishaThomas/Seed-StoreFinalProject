package com.promineotech.seeds.controller;

import java.util.List;   
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.seeds.entity.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/seedstore")
@OpenAPIDefinition(info = @Info(title = "CustomerService"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomerController {
  
  @Operation(
      summary=  "Returns customer.",
      description = "Returns a customer given customer id.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A customer list is returned.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No customers were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "A unplanned error occurred.",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "customer_id", 
              allowEmptyValue = false, 
              required = true, 
              description = "The customer id."),
        @Parameter( 
            name = "first_name",
            allowEmptyValue = false, required = false,
            description ="The customer first name."),
        @Parameter(
            name = "last_name", 
            allowEmptyValue = false, 
            required = false, 
            description ="The customer last name."),
       
      }
)
  
@GetMapping("/customers")   
@ResponseStatus(code = HttpStatus.OK)
List<Customer> getCustomers(
    @RequestParam(required = false) 
        int customer_id,
    @RequestParam(required = false)
        String first_name, 
    @RequestParam(required = false) 
        String last_name);
  
  @Operation(
      summary = "Creates a new customer.",
      description = " Returns the created customer",
      responses = {
              @ApiResponse(
                      responseCode = "201",
                      description = " The created customer is returned",
                      content = @Content(mediaType = " Application/json",
                              schema = @Schema(implementation = Customer.class))),
              @ApiResponse(responseCode = "400",
                      description = "The request parameters are invalid",
                      content = @Content(mediaType = " Application/json")),
              @ApiResponse(responseCode = "500",
                      description = "An unplanned error occured.",
                      content = @Content(mediaType = " Application/json"))})
        
      @PostMapping("/add-customer/")   
      @ResponseStatus(code = HttpStatus.CREATED)
      Customer addCustomers(@RequestBody Customer customer);

        @Operation(
            summary=  "Updates a customer.",
            description = "Updates a customer using customer id, first name, last name "
               +"street, city, state, zip, email or phone number.",
            responses = {
                @ApiResponse(
                    responseCode = "200", 
                    description = "A customer is updated.", 
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Customer.class))),
                @ApiResponse(
                    responseCode = "400", 
                    description = "The request parameters are invalid.",
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "404",
                    description = "Unable to update customer with the input criteria.",
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "500",
                    description = "A unplanned error occurred.",
                    content = @Content(mediaType = "application/json"))
            },
                parameters = {
                    @Parameter(
                        name = "customer_id", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer id."),
                    @Parameter(
                        name = "first_name", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer first name."),
                    @Parameter(
                        name = "last_name", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer last name."),
                    @Parameter(
                        name = "street", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's street."),
                    @Parameter(
                        name = "city", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's city."),
                    @Parameter(
                        name = "state", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's state."),
                    @Parameter(
                        name = "zip", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's zip code."),
                    @Parameter(
                        name = "email", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's email."),
                    @Parameter(
                        name = "phone", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer's phone."),
            }
        )
        
        @PutMapping("/update-customer")   
        @ResponseStatus(code = HttpStatus.OK)
        Optional<Customer> updateCustomers(
            @RequestParam(required = true) 
                int customer_id,
            @RequestParam(required = true)
                String first_name, 
            @RequestParam(required = true) 
                String last_name,
            @RequestParam(required = false) 
                String street,
            @RequestParam(required = false)
                String city, 
            @RequestParam(required = false) 
                String state,
           @RequestParam(required = false) 
                String zip,
            @RequestParam(required = false)
                String email, 
            @RequestParam(required = false) 
                String phone);
        
        @Operation(
            summary=  "Deletes a customer.",
            description = "Deletes a customer using customer id, first name, last name\"\n"
               +"street, city, state, zip, email and phone number.",
            responses = {
                @ApiResponse(
                    responseCode = "200", 
                    description = "A customer is deleted.", 
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Customer.class))),
                @ApiResponse(
                    responseCode = "400", 
                    description = "The request parameters are invalid.",
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "404",
                    description = "Unable to delete customer with the input criteria.",
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "500",
                    description = "A unplanned error occurred.",
                    content = @Content(mediaType = "application/json"))
            },
                parameters = {
                    @Parameter(
                        name = "customer_id", 
                        allowEmptyValue = false, 
                        required = true, 
                        description = "The customer id."),
                    @Parameter(
                        name = "first_name", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer first name."),
                    @Parameter(
                        name = "last_name", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The customer last name."),
                    @Parameter(
                        name = "street", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's street."),
                    @Parameter(
                        name = "city", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's city."),
                    @Parameter(
                        name = "state", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's state."),
                    @Parameter(
                        name = "zip", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's zip code."),
                    @Parameter(
                        name = "email", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's email."),
                    @Parameter(
                        name = "phone", 
                        allowEmptyValue = true, 
                        required = false, 
                        description = "The customer's phone."),
            }
        )
        
        @DeleteMapping("/delete-customer")   
        @ResponseStatus(code = HttpStatus.OK)
        Optional<Customer> deleteCustomers(
            @RequestParam(required = false) 
                int customer_id,
            @RequestParam(required = false)
                String first_name, 
            @RequestParam(required = false) 
                String last_name,
            @RequestParam(required = false) 
                String street,
            @RequestParam(required = false)
                String city, 
            @RequestParam(required = false) 
                String state,
           @RequestParam(required = false) 
                String zip,
            @RequestParam(required = false)
                String email, 
            @RequestParam(required = false) 
                String phone);
}

