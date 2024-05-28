package com.pede.ai.infra.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.pede.ai.infra.entities.ItemOrderEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class ItemOrderEntity {

    final static String TABLE_NAME = "ITEMS";

    public ItemOrderEntity(
            BigDecimal totalPrice,
            Integer amount,
            Long productId,
            OrderEntity order,
            LocalDateTime createdAt
    ) {
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.productId = productId;
        this.order = order;
        this.createdAt = createdAt;
    }

    public ItemOrderEntity(
            BigDecimal totalPrice,
            Integer amount,
            Long productId,
            LocalDateTime createdAt
    ) {
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.productId = productId;
        this.createdAt = createdAt;
    }

    public ItemOrderEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_ITEM")
    public Long id;

    public BigDecimal totalPrice;
    public Integer amount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = true)
    public OrderEntity order;

    public Long productId;
    public LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
