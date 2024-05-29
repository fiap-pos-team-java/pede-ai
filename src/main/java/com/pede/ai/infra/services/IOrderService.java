package com.pede.ai.infra.services;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.inbounds.forms.ItemOrderForm;

import java.util.List;

public interface IOrderService {
    List<DomainItemOrder> convertDomainItemOrder(List<ItemOrderForm> itemOrderFormList);
}
