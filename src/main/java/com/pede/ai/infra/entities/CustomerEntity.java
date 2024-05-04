package com.pede.ai.infra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

import static com.pede.ai.infra.entities.CustomerEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class CustomerEntity {

  final static String TABLE_NAME = "CUSTOMERS";

  public CustomerEntity(
      String name,
      String email,
      String cpf,
      LocalDateTime createdAt
  ) {
    this.name = name;
    this.email = email;
    this.cpf = cpf;
    this.createdAt = createdAt;
  }

  public CustomerEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDT_CUSTOMER")
  public Long id;

  @Column(name = "DES_NAME")
  public String name;

  @Column(name = "DES_EMAIL")
  public String email;

  @Column(name = "DES_CPF")
  public String cpf;

  @Column(name = "DAT_CREATED")
  public LocalDateTime createdAt;
}
