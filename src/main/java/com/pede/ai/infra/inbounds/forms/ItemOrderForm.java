package com.pede.ai.infra.inbounds.forms;

import com.pede.ai.core.domain.order.DomainItemOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemOrderForm(
        Integer amount,
        Long productId,
        String notes
) {

    public DomainItemOrder toDomain(BigDecimal totalPrice) {
        return
            new DomainItemOrder(
                    null,
                    totalPrice,
                    this.amount,
                    this.productId,
                    LocalDateTime.now()
            );
    }

}
