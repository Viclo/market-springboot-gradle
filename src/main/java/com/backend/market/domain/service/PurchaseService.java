package com.backend.market.domain.service;

import com.backend.market.domain.dto.PurchaseDto;
import com.backend.market.domain.repository.PurchaseRepositoryDomain;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {

  private final PurchaseRepositoryDomain purchaseRepositoryDomain;

  public List<PurchaseDto> getAll() {
    return purchaseRepositoryDomain.getAll();
  }

  public Optional<PurchaseDto> getPurchase(Long idPurchase) {
    return purchaseRepositoryDomain.getPurchase(idPurchase);
  }

  public Optional<List<PurchaseDto>> getByCustomer(String idCustomer) {
    return purchaseRepositoryDomain.getByCustomer(idCustomer);
  }

  public Optional<List<PurchaseDto>> getByDate(LocalDateTime date) {
    return purchaseRepositoryDomain.getByDate(date);
  }

  public PurchaseDto save(PurchaseDto purchaseDto) {
    return purchaseRepositoryDomain.save(purchaseDto);
  }
}
