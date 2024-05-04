package com.pede.ai.core.domain.customer;

import java.time.LocalDateTime;

public record DomainCustomer(
    Long id,
    String name,
    String email,
    String cpf,
    LocalDateTime createdAt
) {
}
