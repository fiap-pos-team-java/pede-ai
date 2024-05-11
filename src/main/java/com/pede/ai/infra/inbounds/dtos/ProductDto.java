package com.pede.ai.infra.inbounds.dtos;

import com.pede.ai.core.commons.enums.ProductType;

import java.time.LocalDateTime;

public record ProductDto(
    Long id,
    String name,
    String desc,
    float price,
    ProductType type,
    LocalDateTime createdAt
) {

}
