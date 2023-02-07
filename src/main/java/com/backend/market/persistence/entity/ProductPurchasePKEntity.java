package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductPurchasePKEntity implements Serializable {

  @Column(name = "id_product")
  private Long idProduct;

  @Column(name = "id_purchase")
  private Long idPurchase;
}
