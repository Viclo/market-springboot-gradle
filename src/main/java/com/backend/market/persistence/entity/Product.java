package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_product")
  private Long idProduct;

  @Column(name = "id_category")
  private Integer idCategory;

  private String name;

  private String barcode;

  private BigDecimal price;

  @Column(name = "stock_quantity")
  private Integer stockQuantity;

  private Boolean state;
}
