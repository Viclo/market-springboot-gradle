package com.backend.market.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_purchases")
public class ProductPurchaseEntity {

  @EmbeddedId
  private ProductPurchasePKEntity idProductPurchase;

  private Integer quantity;

  private BigDecimal total;

  private Boolean state;

  @ManyToOne
  @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
  private PurchaseEntity purchaseEntity;

  @ManyToOne
  @JoinColumn(name = "id_product", insertable = false, updatable = false)
  private ProductEntity productEntity;
}
