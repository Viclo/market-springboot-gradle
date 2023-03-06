package com.backend.market.domain.repository;

import com.backend.market.domain.Purchase;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDomain {

  List<Purchase> getAll();
  Optional<Purchase> getPurchase(Long idPurchase);
  Optional<List<Purchase>> getByCustomer(String idCustomer);
  Optional<List<Purchase>> getByDate(LocalDateTime date);
  Purchase save(Purchase purchase);
}
