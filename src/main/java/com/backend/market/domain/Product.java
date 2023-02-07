package com.backend.market.domain;

import java.math.BigDecimal;

public class Product {

  private Long idProductDomain;
  private Long idCategoryDomain;
  private String name;
  private BigDecimal price;
  private Integer stockQuantity;
  private Boolean active;
  private Category category;

  public Long getIdProductDomain() {
    return idProductDomain;
  }

  public void setIdProductDomain(Long idProductDomain) {
    this.idProductDomain = idProductDomain;
  }

  public Long getIdCategoryDomain() {
    return idCategoryDomain;
  }

  public void setIdCategoryDomain(Long idCategoryDomain) {
    this.idCategoryDomain = idCategoryDomain;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
