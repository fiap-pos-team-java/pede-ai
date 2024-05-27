package com.pede.ai.infra.entities;

import com.pede.ai.core.commons.enums.OrderStatusType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.pede.ai.infra.entities.OrderEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class ItemOrderEntity {

    final static String TABLE_NAME = "ITEM_ORDER";

    public ItemOrderEntity(
            Long id,
            BigDecimal totalPrice,
            Integer amount,
            OrderEntity order,
            Long productId,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.order = order;
        this.productId = productId;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalPrice;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity order;

    private Long productId;
    private LocalDateTime createdAt;

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
