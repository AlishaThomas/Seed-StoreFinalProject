package com.promineotech.seeds.controller;

  import java.util.List;     
  import org.springframework.http.HttpStatus;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.ResponseStatus;
  import com.promineotech.seeds.entity.Products;
  import com.promineotech.seeds.entity.Seed;
  import com.promineotech.seeds.entity.SeedType;
  import io.swagger.v3.oas.annotations.OpenAPIDefinition;
  import io.swagger.v3.oas.annotations.Operation;
  import io.swagger.v3.oas.annotations.Parameter;
  import io.swagger.v3.oas.annotations.info.Info;
  import io.swagger.v3.oas.annotations.media.Content;
  import io.swagger.v3.oas.annotations.media.Schema;
  import io.swagger.v3.oas.annotations.responses.ApiResponse;
  import io.swagger.v3.oas.annotations.servers.Server;


  @RequestMapping("/seedstore/products")
  @OpenAPIDefinition(info = @Info(title = "Products Service"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface ProductsController {
    @Operation(
        summary= "Returns a product.",
        description = "Returns a product given type and name.",
       
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A seed order is returned.", 
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Products.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid.",
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404",
                description = "No products were found with the input criteria.",
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500",
                description = "A unplanned error occurred.",
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "seedType", 
                allowEmptyValue = false, 
                required = false, 
                description = "The product type."),
            @Parameter(
                name = "name", 
                allowEmptyValue = false, 
                required = false, 
                description = "The product name."),
        }
  )     
  @GetMapping("/get-seeds")   
  @ResponseStatus(code = HttpStatus.OK)
  List<Products> getSeeds( 
      @RequestParam(required = false) 
          SeedType seedType,
      @RequestParam(required = false)
          String name);
    
    
    @Operation(
        summary = "Returns a list of seeds.",
        description = "Returns a list of seeds.",
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = " The list of seeds is returned",
                        content = @Content(mediaType = " Application/json",
                                schema = @Schema(implementation = Seed.class))),
                @ApiResponse(responseCode = "400",
                        description = "The request parameters are invalid",
                        content = @Content(mediaType = " Application/json")),
                @ApiResponse(responseCode = "500",
                        description = "An unplanned error occured.",
                        content = @Content(mediaType = " Application/json"))
                })
    
    
    @GetMapping("/get-all-seeds")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Seed> getAllSeeds();

   
  }











