package com.backend.market.domain.dto;

public class CategoryDto {

  private Long idCategoryDomain;
  private String category;
  private Boolean active;

  public Long getIdCategoryDomain() {
    return idCategoryDomain;
  }

  public void setIdCategoryDomain(Long idCategoryDomain) {
    this.idCategoryDomain = idCategoryDomain;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
