package com.pede.ai.core.domain.order;

import com.pede.ai.core.commons.enums.OrderStatusType;
import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.core.domain.product.DomainProduct;

import java.time.LocalDateTime;
import java.util.List;

public record DomainOrder(
        Long id,
        OrderStatusType status,
        String custumerCpf,
        List<DomainItemOrder> productList,
        LocalDateTime createdAt
) {
}
