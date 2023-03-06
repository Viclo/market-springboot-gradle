package com.backend.market.domain.repository;

import com.backend.market.domain.dto.PurchaseDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDomain {

  List<PurchaseDto> getAll();
  Optional<PurchaseDto> getPurchase(Long idPurchase);
  Optional<List<PurchaseDto>> getByCustomer(String idCustomer);
  Optional<List<PurchaseDto>> getByDate(LocalDateTime date);
  PurchaseDto save(PurchaseDto purchaseDto);
}
