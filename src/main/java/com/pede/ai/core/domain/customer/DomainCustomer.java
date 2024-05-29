package com.pede.ai.core.domain.customer;

import com.pede.ai.core.commons.Cpf;

import java.time.LocalDateTime;

public record DomainCustomer(
    Long id,
    String name,
    String email,
    Cpf cpf,
    LocalDateTime createdAt
) {
}
