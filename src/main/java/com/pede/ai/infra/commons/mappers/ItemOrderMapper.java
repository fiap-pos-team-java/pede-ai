package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.entities.ItemOrderEntity;
import com.pede.ai.infra.entities.OrderEntity;

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
                domainItemOrder.id(),
                domainItemOrder.totalPrice(),
                domainItemOrder.amount(),
                null,
                domainItemOrder.productId(),
                domainItemOrder.createdAt()
        );
    }

}
