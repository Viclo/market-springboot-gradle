package com.backend.market.domain.repository;

import com.backend.market.domain.Purchase;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDomain {

  List<Purchase> getAll();
  Optional<List<Purchase>> getByCustomer(Long idCustomer);
  Purchase save(Purchase purchase);
}
