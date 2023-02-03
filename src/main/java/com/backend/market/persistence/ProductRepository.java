package com.backend.market.persistence;

import com.backend.market.persistence.crud.ProductCrudRepository;
import com.backend.market.persistence.entity.Product;
import java.util.List;

public class ProductRepository {

  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }
}
