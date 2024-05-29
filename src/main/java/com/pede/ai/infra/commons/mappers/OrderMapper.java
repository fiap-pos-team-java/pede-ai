package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.infra.entities.OrderEntity;
import com.pede.ai.infra.inbounds.dtos.OrderDto;

public class OrderMapper {

    public static DomainOrder toDomain(OrderEntity orderEntity) {
        return new DomainOrder(
                orderEntity.getId(),
                orderEntity.getStatus(),
                orderEntity.getCustomerCpf(),
                ItemOrderMapper.toDomainList(orderEntity.getItems()),
                orderEntity.getCreatedAt()
        );
    }

    public static DomainOrder toDomainList(OrderEntity orderEntity) {
        return new DomainOrder(
                orderEntity.getId(),
                orderEntity.getStatus(),
                orderEntity.getCustomerCpf(),
                ItemOrderMapper.toDomainList(orderEntity.getItems()),
                orderEntity.getCreatedAt()
        );
    }

    public static OrderEntity toEntity(DomainOrder domainOrder) {
        return new OrderEntity(
                domainOrder.status(),
                domainOrder.customerCpf(),
                ItemOrderMapper.toEntityList(domainOrder.productList()),
                domainOrder.createdAt()
        );
    }

    public static OrderDto toDto(DomainOrder domainOrder) {
        return new OrderDto(
                domainOrder.status(),
                domainOrder.customerCpf(),
                ItemOrderMapper.toDtoList(domainOrder.productList()),
                domainOrder.createdAt()
        );
    }

}
