package com.backend.market.domain.repository;

import com.backend.market.domain.dto.ProductDto;
import java.util.Optional;
import java.util.List;

public interface ProductRepositoryDomain {

  List<ProductDto> getAll();
  Optional<ProductDto> getProduct(Long idProduct);
  Optional<List<ProductDto>> getByCategory(Long idCategory);
  Optional<List<ProductDto>> getScareProducts(Integer quantity);
  ProductDto saveProduct(ProductDto productDto);
  void deleteProduct(Long idProduct);
}
