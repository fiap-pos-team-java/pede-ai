package com.pede.ai.infra.inbounds.dtos;

import com.pede.ai.core.commons.enums.OrderStatusType;
import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record OrderDto(
        Long id,
        OrderStatusType status,
        DomainCustomer custumer,
        List<ItemOrderDto> productList,
        LocalDateTime createdAt
) {
}
