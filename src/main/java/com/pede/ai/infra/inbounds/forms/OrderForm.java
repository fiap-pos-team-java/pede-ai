package com.pede.ai.infra.inbounds.forms;

import com.pede.ai.core.commons.enums.OrderStatusType;
import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;

import java.time.LocalDateTime;
import java.util.List;

public record OrderForm(
        OrderStatusType status,
        String customerCpf,
        List<ItemOrderForm> productList
) {

    public DomainOrder toDomain(List<DomainItemOrder> itemOrderForm) {
        return
            new DomainOrder(
                    null,
                    this.status,
                    this.customerCpf,
                    itemOrderForm,
                    LocalDateTime.now()
            );
    }

}
