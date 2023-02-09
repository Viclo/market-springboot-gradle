package com.backend.market.persistence;

import com.backend.market.domain.Purchase;
import com.backend.market.domain.repository.PurchaseRepositoryDomain;
import com.backend.market.persistence.crud.PurchaseCrudRepository;
import com.backend.market.persistence.entity.PurchaseEntity;
import com.backend.market.persistence.mapper.PurchaseMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository implements PurchaseRepositoryDomain {

  @Autowired
  private PurchaseCrudRepository purchaseCrudRepository;

  @Autowired
  private PurchaseMapper purchaseMapper;

  @Override
  public List<Purchase> getAll() {
    return purchaseMapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByCustomer(Long idCustomer) {
    return purchaseCrudRepository.findByIdCustomer(idCustomer)
        .map(purchases -> purchaseMapper.toPurchases(purchases));
  }

  @Override
  public Purchase save(Purchase purchase) {
    PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
    purchaseEntity.getProductPurchaseEntities().forEach(product -> product.setPurchaseEntity(purchaseEntity));
    return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
  }
}
