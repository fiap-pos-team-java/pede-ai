package com.pede.ai.infra.adapters;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.ports.outbound.IOrderRepositoryPort;
import com.pede.ai.infra.commons.mappers.ItemOrderMapper;
import com.pede.ai.infra.commons.mappers.OrderMapper;
import com.pede.ai.infra.entities.ItemOrderEntity;
import com.pede.ai.infra.entities.OrderEntity;
import com.pede.ai.infra.outbounds.IItemOrderRepository;
import com.pede.ai.infra.outbounds.IOrderRepository;
import com.pede.ai.infra.outbounds.IProductRepository;
import com.pede.ai.infra.services.IProductService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderRepositoryAdapter implements IOrderRepositoryPort {

  @Autowired
  private IOrderRepository orderRepository;

  @Autowired
  private IItemOrderRepository itemOrderRepository;

  @Autowired
  private IProductRepository productRepository;

  @Autowired
  private IProductService productService;

  @Autowired
  private EntityManager entityManager;

  @Override
  @Transactional
  public DomainOrder save(DomainOrder domainOrder) {
//    List<ItemOrderEntity> itemOrderEntityList = new ArrayList<>();
//    for(DomainItemOrder domainItemOrder : domainOrder.productList()) {
//      itemOrderRepository.save(domainItemOrder);
//      itemOrderEntityList.add(itemOrderRepository.save(domainItemOrder));
//    }

    OrderEntity orderEntity = orderRepository.save(OrderMapper.toEntity(domainOrder));
//    orderEntity.setItems(itemOrderEntityList);
//    orderRepository.save(orderEntity);

    return OrderMapper.toDomain(orderEntity);
  }

}