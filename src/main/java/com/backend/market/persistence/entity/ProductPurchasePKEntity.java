package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductPurchasePKEntity implements Serializable {

  @Column(name = "id_product")
  private Long idProduct;

  @Column(name = "id_purchase")
  private Long idPurchase;

  public Long getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Long idProduct) {
    this.idProduct = idProduct;
  }

  public Long getIdPurchase() {
    return idPurchase;
  }

  public void setIdPurchase(Long idPurchase) {
    this.idPurchase = idPurchase;
  }
}
