package com.backend.market.persistence;

import com.backend.market.domain.dto.PurchaseDto;
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
  public List<PurchaseDto> getAll() {
    List<PurchaseEntity> purchaseEntityList = (List<PurchaseEntity>) purchaseCrudRepository.findAll();
    return purchaseMapper.toPurchases(purchaseEntityList);
  }

  @Override
  public Optional<PurchaseDto> getPurchase(Long idPurchase) {
    return purchaseCrudRepository.findById(idPurchase)
        .map(purchase -> purchaseMapper.toPurchase(purchase));
  }

  @Override
  public Optional<List<PurchaseDto>> getByCustomer(String idCustomer) {
    return purchaseCrudRepository.findByIdCustomer(idCustomer)
        .map(purchases -> purchaseMapper.toPurchases(purchases));
  }

  @Override
  public Optional<List<PurchaseDto>> getByDate(LocalDateTime date) {
    return purchaseCrudRepository.findAllByDate(date)
        .map(purchases -> purchaseMapper.toPurchases(purchases));
  }

  @Override
  public PurchaseDto save(PurchaseDto purchaseDto) {
    PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchaseDto);
    purchaseEntity.getProductPurchaseEntities().forEach(productPurchaseEntity -> productPurchaseEntity.setPurchaseEntity(purchaseEntity));
    return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
  }
}
