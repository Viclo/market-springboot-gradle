package com.backend.market.web.controller;

import com.backend.market.domain.Product;
import com.backend.market.domain.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping()
  public List<Product> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable("id") Long idProduct) {
    return productService.getProduct(idProduct);
  }

  @GetMapping("/category/{id}")
  public Optional<List<Product>> getByCategory(@PathVariable("id") Long idCategory) {
    return productService.getByCategory(idCategory);
  }

  @GetMapping("/scareProducts/{quantity}")
  public Optional<List<Product>> getScareProducts(@PathVariable("quantity") Integer quantity) {
    return productService.getScareProducts(quantity);
  }

  @PostMapping()
  public Product save(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  @DeleteMapping("/delete/{id}")
  public Boolean delete(@PathVariable("id") Long idProduct) {
    return productService.deleteProduct(idProduct);
  }
}
