package com.backend.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

  private Long idPurchase;
  private Long idCustomer;
  private LocalDateTime date;
  private String paymentMethod;
  private String comment;
  private String state;
  private List<PurchaseItem> items;

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

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public List<PurchaseItem> getItems() {
    return items;
  }

  public void setItems(List<PurchaseItem> items) {
    this.items = items;
  }
}
