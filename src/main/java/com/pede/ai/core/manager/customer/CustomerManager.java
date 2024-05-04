package com.pede.ai.core.manager.customer;

import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.core.ports.inbound.ICustomerManager;
import com.pede.ai.core.ports.outbound.ICustomerRepositoryPort;

import java.util.List;

public class CustomerManager implements ICustomerManager {

    private final ICustomerRepositoryPort iCustomerRepositoryPort;

    public CustomerManager(ICustomerRepositoryPort iCustomerRepositoryPort) {
      this.iCustomerRepositoryPort = iCustomerRepositoryPort;
    }
    @Override
    public DomainCustomer save(DomainCustomer domainCustomer) {
      return iCustomerRepositoryPort.save(domainCustomer);
    }

    @Override
    public List<DomainCustomer> getAll() {
      return iCustomerRepositoryPort.getAll();
    }

}
