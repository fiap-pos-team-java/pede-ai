package com.pede.ai.infra.entities;

import com.pede.ai.core.commons.enums.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.pede.ai.infra.entities.ProductEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class ProductEntity {

  final static String TABLE_NAME = "PRODUCTS";

  public ProductEntity(
      String name,
      String desc,
      BigDecimal price,
      ProductType type,
      LocalDateTime createdAt
  ) {
    this.name = name;
    this.desc = desc;
    this.price = price;
    this.type = type;
    this.createdAt = createdAt;
  }

  public ProductEntity(
          Long id,
          String name,
          String desc,
          BigDecimal price,
          ProductType type,
          LocalDateTime createdAt
  ) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.price = price;
    this.type = type;
    this.createdAt = createdAt;
  }

  public ProductEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDT_PRODUCT")
  public Long id;

  @Column(name = "DES_NAME")
  public String name;

  @Column(name = "DES_DESC")
  public String desc;

  @Column(name = "DES_PRICE")
  public BigDecimal price;

  @Enumerated(EnumType.STRING)
  @Column(name = "DES_TYPE")
  public ProductType type;

  @Column(name = "DAT_CREATED")
  public LocalDateTime createdAt;
}
