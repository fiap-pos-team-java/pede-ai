package com.pede.ai.infra.outbounds;

import com.pede.ai.infra.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByCpf(String cpf);
}
