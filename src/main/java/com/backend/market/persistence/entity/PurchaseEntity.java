package com.backend.market.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_purchase")
  private Long idPurchase;

  @Column(name = "id_customer")
  private Long idCustomer;

  private LocalDateTime date;

  @Column(name = "half_pay")
  private String halfPay;

  private String commentary;

  private String state;

  @ManyToOne
  @JoinColumn(name = "id_customer", insertable = false, updatable = false)
  private CustomerEntity customerEntity;

  @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
  private List<ProductPurchaseEntity> productPurchaseEntities;

  public Long getIdPurchase() {
    return idPurchase;
  }

  public void setIdPurchase(Long idPurchase) {
    this.idPurchase = idPurchase;
  }

  public Long getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(Long idCustomer) {
    this.idCustomer = idCustomer;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getHalfPay() {
    return halfPay;
  }

  public void setHalfPay(String halfPay) {
    this.halfPay = halfPay;
  }

  public String getCommentary() {
    return commentary;
  }

  public void setCommentary(String commentary) {
    this.commentary = commentary;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CustomerEntity getCustomerEntity() {
    return customerEntity;
  }

  public void setCustomerEntity(CustomerEntity customerEntity) {
    this.customerEntity = customerEntity;
  }

  public List<ProductPurchaseEntity> getProductPurchaseEntities() {
    return productPurchaseEntities;
  }

  public void setProductPurchaseEntities(
      List<ProductPurchaseEntity> productPurchaseEntities) {
    this.productPurchaseEntities = productPurchaseEntities;
  }
}
