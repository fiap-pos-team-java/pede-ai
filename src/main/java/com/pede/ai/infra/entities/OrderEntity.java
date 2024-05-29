package com.pede.ai.infra.entities;

import com.pede.ai.core.commons.enums.OrderStatusType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.pede.ai.infra.entities.OrderEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class OrderEntity {

  final static String TABLE_NAME = "ORDERS";

  public OrderEntity(
          OrderStatusType status,
          String customerCpf,
          List<ItemOrderEntity> items,
          LocalDateTime createdAt
  ) {
    this.status = status;
    this.customerCpf = customerCpf;
    this.items = items;
    this.createdAt = createdAt;
  }

  public OrderEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDT_ORDER")
  public Long id;

  @Column(name = "DES_STATUS")
  public OrderStatusType status;

  @Column(name = "DES_CUSTOMER_CPF")
  public String customerCpf;

  @OneToMany(mappedBy = "order")
  public List<ItemOrderEntity> items;

  @Column(name = "DAT_CREATED")
  public LocalDateTime createdAt;

  public Long getId() {
    return id;
  }

  public OrderStatusType getStatus() {
    return status;
  }

  public String getCustomerCpf() {
    return customerCpf;
  }

  public List<ItemOrderEntity> getItems() {
    return items;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

}
