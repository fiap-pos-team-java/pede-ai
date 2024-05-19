package com.pede.ai.infra.adapters;

import com.pede.ai.core.commons.Cpf;
import com.pede.ai.core.exceptions.NotFoundException;
import com.pede.ai.infra.entities.CustomerEntity;
import com.pede.ai.infra.outbounds.ICustomerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryAdapterTest {

    @Mock
    private ICustomerRepository customerRepositoryMock;

    @Mock
    private Cpf validateCpf;

    @InjectMocks
    private CustomerRepositoryAdapter customerRepositoryAdapter;

    private final String validCpf = "38080997802";
    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Before("")
    public void setUp() {
        when(customerRepositoryMock.findByCpf(validCpf)).thenReturn(Optional.of(new CustomerEntity("Nome do Cliente", "teste@email.com", validCpf, localDateTime)));
    }

    @Test
    public void invalidCpfNotFoundTest() {
        assertThrows(NotFoundException.class, () -> customerRepositoryAdapter.getByCpf("12345678901"));
    }

}