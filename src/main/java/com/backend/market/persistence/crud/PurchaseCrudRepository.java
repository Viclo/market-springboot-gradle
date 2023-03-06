package com.backend.market.persistence.crud;

import com.backend.market.persistence.entity.PurchaseEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Long> {

  Optional<List<PurchaseEntity>> findByIdCustomer(String idCustomer);

  Optional<List<PurchaseEntity>> findAllByDate(LocalDateTime date);
}
