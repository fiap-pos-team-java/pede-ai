package com.pede.ai.config;

import com.pede.ai.core.manager.customer.CustomerManager;
import com.pede.ai.core.ports.inbound.ICustomerManager;
import com.pede.ai.core.ports.outbound.ICustomerRepositoryPort;
import com.pede.ai.infra.adapters.CustomerRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ICustomerRepositoryPort customerRepositoryPort() {
      return new CustomerRepositoryAdapter();
    }

    @Bean
    public ICustomerManager customerManager() {
      return new CustomerManager(customerRepositoryPort());
    }

}
