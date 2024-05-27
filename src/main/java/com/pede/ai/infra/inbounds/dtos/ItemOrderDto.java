package com.pede.ai.infra.inbounds.dtos;

import com.pede.ai.core.commons.enums.OrderStatusType;
import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ItemOrderDto(
        Long id,
        BigDecimal totalPrice,
        Integer amount,
        DomainProduct product,
        LocalDateTime createdAt
) {
}
