package com.pede.ai.core.ports.inbound;

import com.pede.ai.core.domain.order.DomainOrder;

import java.util.List;

public interface IOrderManager {

    DomainOrder save(DomainOrder domainOrder);
    List<DomainOrder> getAll();

}