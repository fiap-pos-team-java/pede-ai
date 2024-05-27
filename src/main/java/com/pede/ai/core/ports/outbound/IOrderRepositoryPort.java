package com.pede.ai.core.ports.outbound;

import com.pede.ai.core.domain.order.DomainOrder;

public interface IOrderRepositoryPort {
    DomainOrder save(DomainOrder domainOrder);
}
