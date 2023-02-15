package com.backend.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_customer")
  private String idCustomer;

  private String name;

  private String lastname;

  @Column(name = "number_phone")
  private Long numberPhone;

  private String address;

  private String email;

  @OneToMany(mappedBy = "customerEntity")
  private List<PurchaseEntity> purchaseEntities;

  public String getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(String idCustomer) {
    this.idCustomer = idCustomer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Long getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(Long numberPhone) {
    this.numberPhone = numberPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<PurchaseEntity> getPurchaseEntities() {
    return purchaseEntities;
  }

  public void setPurchaseEntities(
      List<PurchaseEntity> purchaseEntities) {
    this.purchaseEntities = purchaseEntities;
  }
}
