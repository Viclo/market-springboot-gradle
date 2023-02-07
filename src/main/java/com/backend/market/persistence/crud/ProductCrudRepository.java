package com.backend.market.persistence.crud;

import com.backend.market.persistence.entity.ProductEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Long> {

  List<ProductEntity> findByIdCategoryOrderByNameAsc(Long idCategory);

  Optional<List<ProductEntity>> findByStockQuantityLessThanAndState(Integer stockQuantity, Boolean state);
}
