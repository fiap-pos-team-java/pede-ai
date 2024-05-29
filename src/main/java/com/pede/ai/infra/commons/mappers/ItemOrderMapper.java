package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.entities.ItemOrderEntity;
import com.pede.ai.infra.entities.OrderEntity;
import com.pede.ai.infra.inbounds.dtos.ItemOrderDto;
import com.pede.ai.infra.inbounds.dtos.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class ItemOrderMapper {

    public static DomainItemOrder toDomain(ItemOrderEntity itemorderEntity) {
        return new DomainItemOrder(
                itemorderEntity.getId(),
                itemorderEntity.getTotalPrice(),
                itemorderEntity.getAmount(),
                itemorderEntity.getProductId(),
                itemorderEntity.getCreatedAt()
        );
    }

    public static List<DomainItemOrder> toDomainList(List<ItemOrderEntity> itemOrderEntityList) {
        return itemOrderEntityList.stream()
                .map(ItemOrderMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static ItemOrderEntity toEntity(DomainItemOrder domainItemOrder) {
        return new ItemOrderEntity(
                domainItemOrder.totalPrice(),
                domainItemOrder.amount(),
                domainItemOrder.productId(),
                domainItemOrder.createdAt()
        );
    }

    public static ItemOrderEntity toEntity2(DomainItemOrder domainItemOrder, OrderEntity orderEntity) {
        return new ItemOrderEntity(
                domainItemOrder.totalPrice(),
                domainItemOrder.amount(),
                domainItemOrder.productId(),
                orderEntity,
                domainItemOrder.createdAt()
        );
    }

    public static List<ItemOrderEntity> toEntityList(List<DomainItemOrder> domainItemOrderList) {
        return domainItemOrderList.stream()
                .map(ItemOrderMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static ItemOrderDto toDto(DomainItemOrder domainItemOrder) {
        return new ItemOrderDto(
                domainItemOrder.totalPrice(),
                domainItemOrder.amount(),
                domainItemOrder.productId(),
                domainItemOrder.createdAt()
        );
    }

    public static List<ItemOrderDto> toDtoList(List<DomainItemOrder> domainItemOrder) {
        return domainItemOrder.stream()
                .map(ItemOrderMapper::toDto)
                .collect(Collectors.toList());
    }

}
