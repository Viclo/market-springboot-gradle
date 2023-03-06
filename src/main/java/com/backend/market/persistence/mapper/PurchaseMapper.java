package com.backend.market.persistence.mapper;

import com.backend.market.domain.Purchase;
import com.backend.market.persistence.entity.PurchaseEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

  @Mapping(source = "idPurchase", target = "idPurchase")
  @Mapping(source = "idCustomer", target = "idCustomer")
  @Mapping(source = "date", target = "date")
  @Mapping(source = "halfPay", target = "paymentMethod")
  @Mapping(source = "commentary", target = "comment")
  @Mapping(source = "state", target = "state")
  @Mapping(source = "productPurchaseEntities", target = "items")
  Purchase toPurchase(PurchaseEntity purchaseEntity);
  List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntityList);

  @InheritInverseConfiguration
  @Mapping(target = "customerEntity", ignore = true)
  PurchaseEntity toPurchaseEntity(Purchase purchase);
}
