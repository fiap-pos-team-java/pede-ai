package com.pede.ai.core.ports.outbound;

import com.pede.ai.core.domain.customer.DomainCustomer;

import java.util.List;

public interface ICustomerRepositoryPort {
    DomainCustomer save(DomainCustomer domainCustomer);
    List<DomainCustomer> getAll();
}
