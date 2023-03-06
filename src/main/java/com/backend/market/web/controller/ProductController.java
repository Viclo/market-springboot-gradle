package com.backend.market.web.controller;

import com.backend.market.domain.dto.ProductDto;
import com.backend.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping()
  @Operation(summary = "Get all products of the marketplace.", responses = {
      @ApiResponse(responseCode = "200", description = "Products found.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Products not found.", content = @Content)
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity<List<ProductDto>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a product by ID.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Product not found.", content = @Content)
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long idProduct) {
    return productService.getProduct(idProduct)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/category/{id}")
  @Operation(summary = "Get products by category.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Category not found.", content = @Content)
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("id") Long idCategory) {
    List<ProductDto> productDtos = productService.getByCategory(idCategory).orElse(null);
    return productDtos != null && !productDtos.isEmpty()? new ResponseEntity<>(productDtos, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/scareProducts/{quantity}")
  @Operation(summary = "Get products by scare.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Products not found.", content = @Content)
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity<List<ProductDto>> getScareProducts(@PathVariable("quantity") Integer quantity) {
    return productService.getScareProducts(quantity)
        .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  @Operation(summary = "Add a product.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
    return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  @Operation(summary = "Remove a product by ID.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Product not found.", content = @Content)
  })
  @SecurityRequirement(name = "Bearer Authentication")
  public ResponseEntity delete(@PathVariable("id") Long idProduct) {
    return productService.deleteProduct(idProduct)? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
