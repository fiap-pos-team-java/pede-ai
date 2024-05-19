package com.pede.ai.core.domain.product;

import com.pede.ai.core.commons.enums.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DomainProduct(
    Long id,
    String name,
    String desc,
    BigDecimal price,
    ProductType type,
    LocalDateTime createdAt
) {
}
