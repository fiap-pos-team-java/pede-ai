package com.pede.ai.infra.inbounds.dtos;

import com.pede.ai.core.commons.enums.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDto(
    Long id,
    String name,
    String desc,
    BigDecimal price,
    ProductType type,
    LocalDateTime createdAt
) {

}
