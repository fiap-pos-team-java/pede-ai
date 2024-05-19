package com.pede.ai.infra.inbounds.forms;

import com.pede.ai.core.commons.Cpf;
import com.pede.ai.core.domain.customer.DomainCustomer;

import java.time.LocalDateTime;

public record CustomerForm(
    String name,
    String email,
    String cpf
) {

  public DomainCustomer toDomain() {
    return
      new DomainCustomer(
    null,
        this.name,
        this.email,
        new Cpf(this.cpf),
        LocalDateTime.now()
      );
  }

}
