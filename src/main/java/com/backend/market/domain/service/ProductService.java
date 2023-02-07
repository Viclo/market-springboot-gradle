package com.backend.market.domain.service;

import com.backend.market.domain.Product;
import com.backend.market.domain.repository.ProductRepositoryDomain;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepositoryDomain productRepositoryDomain;

  public List<Product> getAll() {
    return productRepositoryDomain.getAll();
  }

  public Optional<Product> getProduct(Long idProduct) {
    return productRepositoryDomain.getProduct(idProduct);
  }

  public Optional<List<Product>> getByCategory(Long idCategory) {
    return productRepositoryDomain.getByCategory(idCategory);
  }

  public Optional<List<Product>> getScareProducts(Integer lowQuantity) {
    return productRepositoryDomain.getScareProducts(lowQuantity);
  }

  public Product saveProduct(Product product) {
    return productRepositoryDomain.saveProduct(product);
  }

  public Boolean deleteProduct(Long idProduct) {
    return getProduct(idProduct).map(product -> {
      productRepositoryDomain.deleteProduct(idProduct);
      return true;
    }).orElse(false);
  }
}
