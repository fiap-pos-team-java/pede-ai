package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.entities.ItemOrderEntity;
import com.pede.ai.infra.entities.OrderEntity;
import com.pede.ai.infra.inbounds.dtos.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public static OrderEntity toEntity(DomainOrder domainOrder) {
        return new OrderEntity(
                domainOrder.id(),
                domainOrder.status(),
                domainOrder.custumerCpf(),
                ProductMapper.toEntityList(domainOrder.productList()),
                domainOrder.createdAt()
        );
    }

}
