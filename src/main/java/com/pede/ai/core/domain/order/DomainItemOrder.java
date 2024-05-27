package com.pede.ai.core.domain.order;

import com.pede.ai.core.domain.product.DomainProduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DomainItemOrder(
        Long id,
        BigDecimal totalPrice,
        Integer amount,
        Long productId,
        LocalDateTime createdAt
) {
}
