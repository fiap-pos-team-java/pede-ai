package com.pede.ai.infra.entities;

import com.pede.ai.core.commons.enums.OrderStatusType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static com.pede.ai.infra.entities.OrderEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class OrderEntity {

  final static String TABLE_NAME = "ORDERS";

  public OrderEntity(
          Long id,
          OrderStatusType status,
          String customerCpf,
          List<ItemOrderEntity> items,
          LocalDateTime createdAt
  ) {
    this.id = id;
    this.status = status;
    this.customerCpf = customerCpf;
    this.items = items;
    this.createdAt = createdAt;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDT_ORDER")
  private Long id;

  @Column(name = "DES_STATUS")
  private OrderStatusType status;

  @Column(name = "DES_CUSTOMER_CPF")
  private String customerCpf;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<ItemOrderEntity> items;

  @Column(name = "DAT_CREATED")
  private LocalDateTime createdAt;

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

  public void setItems(List<ItemOrderEntity> items) {
    this.items = items;
  }
}
