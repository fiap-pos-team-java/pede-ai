package com.pede.ai.core.domain.product;

import com.pede.ai.infra.commons.enums.ProductType;

import java.time.LocalDateTime;

public record DomainProduct(
    Long id,
    String name,
    String desc,
    float price,
    ProductType type,
    LocalDateTime createdAt
) {
}
