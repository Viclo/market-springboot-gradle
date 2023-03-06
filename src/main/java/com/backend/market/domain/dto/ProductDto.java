package com.backend.market.domain.dto;

import java.math.BigDecimal;

public class ProductDto {

  private Long idProductDomain;
  private Long idCategoryDomain;
  private String name;
  private BigDecimal price;
  private Integer stockQuantity;
  private Boolean active;
  private CategoryDto categoryDto;

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

  public CategoryDto getCategory() {
    return categoryDto;
  }

  public void setCategory(CategoryDto categoryDto) {
    this.categoryDto = categoryDto;
  }
}
