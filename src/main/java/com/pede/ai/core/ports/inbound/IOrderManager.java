package com.pede.ai.core.ports.inbound;

import com.pede.ai.core.domain.order.DomainOrder;

public interface IOrderManager {

    DomainOrder save(DomainOrder domainOrder);

}