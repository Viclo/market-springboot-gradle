package com.backend.market.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDto {

  private Long idPurchase;
  private String idCustomer;
  private LocalDateTime date;
  private String paymentMethod;
  private String comment;
  private String state;
  private List<PurchaseItemDto> items;

  public Long getIdPurchase() {
    return idPurchase;
  }

  public void setIdPurchase(Long idPurchase) {
    this.idPurchase = idPurchase;
  }

  public String getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(String idCustomer) {
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

  public List<PurchaseItemDto> getItems() {
    return items;
  }

  public void setItems(List<PurchaseItemDto> items) {
    this.items = items;
  }
}
