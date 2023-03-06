package com.backend.market.domain.dto;

import java.math.BigDecimal;

public class PurchaseItemDto {

  private Long idProduct;
  private Integer quantity;
  private BigDecimal total;
  private Boolean state;

  public Long getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Long idProduct) {
    this.idProduct = idProduct;
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
}
