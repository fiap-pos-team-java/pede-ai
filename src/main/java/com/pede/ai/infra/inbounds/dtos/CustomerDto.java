package com.pede.ai.infra.inbounds.dtos;

import java.time.LocalDateTime;

public record CustomerDto (
    String name,
    String email,
    String cpf,
    LocalDateTime createdAt
) {

}
