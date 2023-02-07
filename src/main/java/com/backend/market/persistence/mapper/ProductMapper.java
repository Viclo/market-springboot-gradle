package com.backend.market.persistence.mapper;

import com.backend.market.domain.Product;
import com.backend.market.persistence.entity.ProductEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

  @Mapping(source = "idProduct", target = "idProductDomain")
  @Mapping(source = "idCategory", target = "idCategoryDomain")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "price", target = "price")
  @Mapping(source = "stockQuantity", target = "stockQuantity")
  @Mapping(source = "state", target = "active")
  @Mapping(source = "categoryEntity", target = "category")
  Product toProduct(ProductEntity productEntity);
  List<Product> toProducts(List<ProductEntity> productEntityList);

  @InheritInverseConfiguration
  @Mapping(target = "barcode", ignore = true)
  ProductEntity toProductEntity(Product product);
}
