package com.pede.ai.core.ports.outbound;

import com.pede.ai.core.domain.order.DomainOrder;

import java.util.List;

public interface IOrderRepositoryPort {
    DomainOrder save(DomainOrder domainOrder);
    List<DomainOrder> getAll();
}
