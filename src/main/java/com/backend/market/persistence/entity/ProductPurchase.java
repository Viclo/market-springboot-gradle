package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "product_purchases")
public class ProductPurchase {

  @EmbeddedId
  private ProductPurchasePK idProductPurchase;

  private Integer quantity;

  private BigDecimal total;

  private Boolean state;
}
