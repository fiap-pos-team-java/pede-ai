package com.pede.ai.infra.inbounds.dtos;

import com.pede.ai.core.commons.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        OrderStatusType status,
        String customerCpf,
        List<ItemOrderDto> productList,
        LocalDateTime createdAt
) {
}
