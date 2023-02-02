package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "purchases")
public class Purchase {

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
}
