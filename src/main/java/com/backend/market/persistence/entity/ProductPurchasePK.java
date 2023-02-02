package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Data
@Embeddable
public class ProductPurchasePK implements Serializable {

  @Column(name = "id_product")
  private Long idProduct;

  @Column(name = "id_purchase")
  private Long idPurchase;
}
