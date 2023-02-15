package com.backend.market.persistence;

import com.backend.market.domain.Purchase;
import com.backend.market.domain.repository.PurchaseRepositoryDomain;
import com.backend.market.persistence.crud.PurchaseCrudRepository;
import com.backend.market.persistence.entity.PurchaseEntity;
import com.backend.market.persistence.mapper.PurchaseMapper;
import java.time.LocalDateTime;
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
    List<PurchaseEntity> purchaseEntityList = (List<PurchaseEntity>) purchaseCrudRepository.findAll();
    return purchaseMapper.toPurchases(purchaseEntityList);
  }

  @Override
  public Optional<Purchase> getPurchase(Long idPurchase) {
    return purchaseCrudRepository.findById(idPurchase)
        .map(purchase -> purchaseMapper.toPurchase(purchase));
  }

  @Override
  public Optional<List<Purchase>> getByCustomer(String idCustomer) {
    return purchaseCrudRepository.findByIdCustomer(idCustomer)
        .map(purchases -> purchaseMapper.toPurchases(purchases));
  }

  @Override
  public Optional<List<Purchase>> getByDate(LocalDateTime date) {
    return purchaseCrudRepository.findAllByDate(date)
        .map(purchases -> purchaseMapper.toPurchases(purchases));
  }

  @Override
  public Purchase save(Purchase purchase) {
    PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
    purchaseEntity.getProductPurchaseEntities().forEach(productPurchaseEntity -> productPurchaseEntity.setPurchaseEntity(purchaseEntity));
    return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
  }
}
