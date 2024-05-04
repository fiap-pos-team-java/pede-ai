package com.pede.ai.core.ports.inbound;

import com.pede.ai.core.domain.customer.DomainCustomer;

import java.util.List;

public interface ICustomerManager {

  DomainCustomer save(DomainCustomer domainCustomer);
  List<DomainCustomer> getAll();

}
