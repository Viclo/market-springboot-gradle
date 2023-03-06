package com.backend.market.persistence;

import com.backend.market.domain.dto.ProductDto;
import com.backend.market.domain.repository.ProductRepositoryDomain;
import com.backend.market.persistence.crud.ProductCrudRepository;
import com.backend.market.persistence.entity.ProductEntity;
import com.backend.market.persistence.mapper.ProductMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryDomain {

  @Autowired
  private ProductCrudRepository productCrudRepository;
  @Autowired
  private ProductMapper productMapper;

  @Override
  public List<ProductDto> getAll() {
    List<ProductEntity> productEntityList = (List<ProductEntity>) productCrudRepository.findAll();
    return productMapper.toProducts(productEntityList);
  }

  @Override
  public Optional<List<ProductDto>> getByCategory(Long idCategory) {
    List<ProductEntity> productEntityList = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    return Optional.of(productMapper.toProducts(productEntityList));
  }

  @Override
  public Optional<List<ProductDto>> getScareProducts(Integer lowQuantity) {
    Optional<List<ProductEntity>> productEntityList = productCrudRepository.findByStockQuantityLessThanAndState(lowQuantity, true);
    return productEntityList.map(productMapper::toProducts);
  }

  @Override
  public Optional<ProductDto> getProduct(Long idProduct) {
    return productCrudRepository.findById(idProduct).map(product -> productMapper.toProduct(product));
  }

  @Override
  public ProductDto saveProduct(ProductDto productDto) {
    ProductEntity productEntity = productMapper.toProductEntity(productDto);
    return productMapper.toProduct(productCrudRepository.save(productEntity));
  }

  @Override
  public void deleteProduct(Long idProduct) {
    productCrudRepository.deleteById(idProduct);
  }
}
