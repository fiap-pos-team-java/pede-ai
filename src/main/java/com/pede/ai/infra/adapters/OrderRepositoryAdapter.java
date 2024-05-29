package com.pede.ai.infra.adapters;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.outbound.IOrderRepositoryPort;
import com.pede.ai.infra.commons.mappers.ItemOrderMapper;
import com.pede.ai.infra.commons.mappers.OrderMapper;
import com.pede.ai.infra.commons.mappers.ProductMapper;
import com.pede.ai.infra.entities.OrderEntity;
import com.pede.ai.infra.outbounds.IItemOrderRepository;
import com.pede.ai.infra.outbounds.IOrderRepository;
import com.pede.ai.infra.outbounds.IProductRepository;
import com.pede.ai.infra.services.IProductService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderRepositoryAdapter implements IOrderRepositoryPort {

  @Autowired
  private IOrderRepository orderRepository;

  @Autowired
  private IItemOrderRepository itemOrderRepository;

  @Autowired
  private IProductRepository productRepository;

  @Override
  @Transactional
  public DomainOrder save(DomainOrder domainOrder) {
    OrderEntity orderEntity = OrderMapper.toEntity(domainOrder);
    OrderEntity newOrderEntity = orderRepository.save(orderEntity);

    for(DomainItemOrder domainItemOrder : domainOrder.productList()) {
      itemOrderRepository.save(ItemOrderMapper.toEntity2(domainItemOrder, newOrderEntity));
    }

    return OrderMapper.toDomain(orderEntity);
  }

  @Override
  public List<DomainOrder> getAll() {
    return orderRepository.findAll().stream()
            .map(OrderMapper::toDomain)
            .toList();
  }

}