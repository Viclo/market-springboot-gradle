package com.backend.market.persistence.mapper;

import com.backend.market.domain.dto.PurchaseItemDto;
import com.backend.market.persistence.entity.ProductPurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PurchaseMapper.class})
public interface PurchaseItemMapper {

  @Mapping(source = "idProductPurchase.idProduct", target = "idProduct")
  PurchaseItemDto toPurchaseItem(ProductPurchaseEntity productPurchaseEntity);

  @InheritInverseConfiguration
  @Mapping(target = "idProductPurchase.idPurchase", ignore = true)
  @Mapping(target = "purchaseEntity", ignore = true)
  @Mapping(target = "productEntity", ignore = true)
  ProductPurchaseEntity toProductPurchaseEntity(PurchaseItemDto purchaseItemDto);
}
