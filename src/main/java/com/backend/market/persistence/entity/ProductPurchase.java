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
public class ProductPurchase {

  @EmbeddedId
  private ProductPurchasePK idProductPurchase;

  private Integer quantity;

  private BigDecimal total;

  private Boolean state;

  @ManyToOne
  @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
  private Purchase purchase;

  @ManyToOne
  @JoinColumn(name = "id_product", insertable = false, updatable = false)
  private Product product;
}
