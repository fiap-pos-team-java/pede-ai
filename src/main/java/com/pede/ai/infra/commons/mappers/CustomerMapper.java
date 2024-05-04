package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.infra.entities.CustomerEntity;
import com.pede.ai.infra.inbounds.dtos.CustomerDto;

public class CustomerMapper {

  public static CustomerEntity toEntity(DomainCustomer domainCustomer) {
    return new CustomerEntity(
            domainCustomer.name(),
            domainCustomer.email(),
            domainCustomer.cpf(),
            domainCustomer.createdAt()
          );
  }

  public static DomainCustomer toDomain(CustomerEntity customerEntity) {
    return new DomainCustomer(
            customerEntity.id,
            customerEntity.name,
            customerEntity.email,
            customerEntity.cpf,
            customerEntity.createdAt
    );
  }

  public static CustomerDto toDto(DomainCustomer domainCustomer) {
    return new CustomerDto(
            domainCustomer.name(),
            domainCustomer.email(),
            domainCustomer.cpf(),
            domainCustomer.createdAt()
    );
  }

}
