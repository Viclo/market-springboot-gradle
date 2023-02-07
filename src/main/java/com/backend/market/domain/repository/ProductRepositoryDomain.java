package com.backend.market.domain.repository;

import com.backend.market.domain.Product;
import java.util.Optional;
import java.util.List;

public interface ProductRepositoryDomain {

  List<Product> getAll();
  Optional<Product> getProduct(Long idProduct);
  Optional<List<Product>> getByCategory(Long idCategory);
  Optional<List<Product>> getScareProducts(Integer quantity);
  Product saveProduct(Product product);
  void deleteProduct(Long idProduct);
}
