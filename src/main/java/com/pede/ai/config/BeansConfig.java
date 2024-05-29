package com.pede.ai.config;

import com.pede.ai.core.manager.customer.CustomerManager;
import com.pede.ai.core.manager.order.OrderManager;
import com.pede.ai.core.manager.product.ProductManager;
import com.pede.ai.core.ports.inbound.ICustomerManager;
import com.pede.ai.core.ports.inbound.IOrderManager;
import com.pede.ai.core.ports.inbound.IProductManager;
import com.pede.ai.core.ports.outbound.ICustomerRepositoryPort;
import com.pede.ai.core.ports.outbound.IOrderRepositoryPort;
import com.pede.ai.core.ports.outbound.IProductRepositoryPort;
import com.pede.ai.infra.adapters.CustomerRepositoryAdapter;
import com.pede.ai.infra.adapters.OrderRepositoryAdapter;
import com.pede.ai.infra.adapters.ProductRepositoryAdapter;
import com.pede.ai.infra.services.IOrderService;
import com.pede.ai.infra.services.IProductService;
import com.pede.ai.infra.services.OrderService;
import com.pede.ai.infra.services.ProductService;
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

    @Bean
    public IProductRepositoryPort productRepositoryPort() {
        return new ProductRepositoryAdapter();
    }

    @Bean
    public IProductManager productManager() { return new ProductManager(productRepositoryPort()); }

    @Bean
    public IOrderRepositoryPort orderRepositoryPort() { return new OrderRepositoryAdapter(); }

    @Bean
    public IOrderManager orderManager() { return new OrderManager(orderRepositoryPort()); }

    @Bean
    public IProductService productService() { return new ProductService(); }

    @Bean
    public IOrderService orderService() { return new OrderService(); }

}