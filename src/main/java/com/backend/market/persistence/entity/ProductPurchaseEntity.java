package com.backend.market.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product_purchases")
public class ProductPurchaseEntity {

  @EmbeddedId
  private ProductPurchasePKEntity idProductPurchase;

  private Integer quantity;

  private BigDecimal total;

  private Boolean state;

  @ManyToOne
  @MapsId("idPurchase")
  @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
  private PurchaseEntity purchaseEntity;

  @ManyToOne
  @JoinColumn(name = "id_product", insertable = false, updatable = false)
  private ProductEntity productEntity;

  public ProductPurchasePKEntity getIdProductPurchase() {
    return idProductPurchase;
  }

  public void setIdProductPurchase(
      ProductPurchasePKEntity idProductPurchase) {
    this.idProductPurchase = idProductPurchase;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Boolean getState() {
    return state;
  }

  public void setState(Boolean state) {
    this.state = state;
  }

  public PurchaseEntity getPurchaseEntity() {
    return purchaseEntity;
  }

  public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
    this.purchaseEntity = purchaseEntity;
  }

  public ProductEntity getProductEntity() {
    return productEntity;
  }

  public void setProductEntity(ProductEntity productEntity) {
    this.productEntity = productEntity;
  }
}
