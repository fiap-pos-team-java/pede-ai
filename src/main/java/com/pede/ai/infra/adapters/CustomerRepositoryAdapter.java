package com.pede.ai.infra.adapters;

import com.pede.ai.core.domain.customer.DomainCustomer;
import com.pede.ai.core.ports.outbound.ICustomerRepositoryPort;
import com.pede.ai.core.exceptions.CommitException;
import com.pede.ai.core.exceptions.NotFoundException;
import com.pede.ai.infra.commons.mappers.CustomerMapper;
import com.pede.ai.infra.outbounds.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CustomerRepositoryAdapter implements ICustomerRepositoryPort {

  @Autowired
  private ICustomerRepository customerRepository;

  @Override
  public DomainCustomer save(DomainCustomer domainCustomer) {
    return Stream.of(domainCustomer)
            .map(CustomerMapper::toEntity)
            .map(customerEntity -> customerRepository.save(customerEntity))
            .map(CustomerMapper::toDomain)
            .findFirst()
            .orElseThrow(() -> new CommitException("The Customer entity can not be saved"));
  }

  @Override
  public List<DomainCustomer> getAll() {
    return customerRepository.findAll().stream()
            .map(CustomerMapper::toDomain)
            .toList();
  }

  @Override
  public DomainCustomer getByCpf(String cpf) {
    return customerRepository.findByCpf(cpf)
            .stream()
            .map(CustomerMapper::toDomain)
            .findFirst()
            .orElseThrow(() -> new NotFoundException(String.format("CPF %s not found", cpf)));
  }

}