package com.backend.market.domain.service;

import com.backend.market.domain.Purchase;
import com.backend.market.domain.repository.PurchaseRepositoryDomain;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

  @Autowired
  private PurchaseRepositoryDomain purchaseRepositoryDomain;

  public List<Purchase> getAll() {
    return purchaseRepositoryDomain.getAll();
  }

  public Optional<Purchase> getPurchase(Long idPurchase) {
    return purchaseRepositoryDomain.getPurchase(idPurchase);
  }

  public Optional<List<Purchase>> getByCustomer(String idCustomer) {
    return purchaseRepositoryDomain.getByCustomer(idCustomer);
  }

  public Optional<List<Purchase>> getByDate(LocalDateTime date) {
    return purchaseRepositoryDomain.getByDate(date);
  }

  public Purchase save(Purchase purchase) {
    return purchaseRepositoryDomain.save(purchase);
  }
}