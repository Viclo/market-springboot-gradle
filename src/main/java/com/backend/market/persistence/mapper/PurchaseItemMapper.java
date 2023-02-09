package com.backend.market.persistence.mapper;

import com.backend.market.domain.PurchaseItem;
import com.backend.market.persistence.entity.ProductPurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

  @Mapping(source = "idProductPurchase.idProduct", target = "idProduct")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "total", target = "total")
  @Mapping(source = "state", target = "state")
  PurchaseItem toPurchaseItem(ProductPurchaseEntity productPurchaseEntity);

  @InheritInverseConfiguration
  @Mapping(target = "idProductPurchase.idPurchase", ignore = true)
  @Mapping(target = "purchaseEntity", ignore = true)
  @Mapping(target = "productEntity", ignore = true)
  ProductPurchaseEntity toProductPurchaseEntity(PurchaseItem purchaseItem);
}
