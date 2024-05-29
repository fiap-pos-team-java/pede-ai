package com.pede.ai.core.domain.order;

import com.pede.ai.core.commons.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.List;

public record DomainOrder(
        Long id,
        OrderStatusType status,
        String customerCpf,
        List<DomainItemOrder> productList,
        LocalDateTime createdAt
) {
}
