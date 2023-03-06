package com.backend.market.domain.service;

import com.backend.market.domain.dto.ProductDto;
import com.backend.market.domain.repository.ProductRepositoryDomain;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepositoryDomain productRepositoryDomain;

  public List<ProductDto> getAll() {
    return productRepositoryDomain.getAll();
  }

  public Optional<ProductDto> getProduct(Long idProduct) {
    return productRepositoryDomain.getProduct(idProduct);
  }

  public Optional<List<ProductDto>> getByCategory(Long idCategory) {
    return productRepositoryDomain.getByCategory(idCategory);
  }

  public Optional<List<ProductDto>> getScareProducts(Integer lowQuantity) {
    return productRepositoryDomain.getScareProducts(lowQuantity);
  }

  public ProductDto saveProduct(ProductDto productDto) {
    return productRepositoryDomain.saveProduct(productDto);
  }

  public Boolean deleteProduct(Long idProduct) {
    return getProduct(idProduct).map(product -> {
      productRepositoryDomain.deleteProduct(idProduct);
      return true;
    }).orElse(false);
  }
}
