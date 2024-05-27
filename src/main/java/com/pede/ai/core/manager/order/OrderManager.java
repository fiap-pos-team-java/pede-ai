package com.pede.ai.core.manager.order;

import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.ports.inbound.IOrderManager;
import com.pede.ai.core.ports.outbound.IOrderRepositoryPort;

public class OrderManager implements IOrderManager {

    private final IOrderRepositoryPort iOrderRepositoryPort;

    public OrderManager(IOrderRepositoryPort iOrderRepositoryPort) {
      this.iOrderRepositoryPort = iOrderRepositoryPort;
    }
    @Override
    public DomainOrder save(DomainOrder domainOrder) {
      return iOrderRepositoryPort.save(domainOrder);
    }

}
