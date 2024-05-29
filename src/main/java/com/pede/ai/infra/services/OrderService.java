package com.pede.ai.infra.services;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.IOrderManager;
import com.pede.ai.infra.adapters.ProductRepositoryAdapter;
import com.pede.ai.infra.inbounds.forms.ItemOrderForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private IOrderManager orderManager;

    @Autowired
    private ProductRepositoryAdapter productRepositoryAdapter;

    public List<DomainItemOrder> convertDomainItemOrder(List<ItemOrderForm> itemOrderFormList) {
        List<DomainItemOrder> domainItemOrderList = new ArrayList<>();
        for(ItemOrderForm itemOrderForm : itemOrderFormList) {
            int amount = itemOrderForm.amount();
            DomainProduct product = productRepositoryAdapter.getById(itemOrderForm.productId());
            BigDecimal totalPrice = BigDecimal.valueOf(amount).multiply(product.price()) ;
            domainItemOrderList.add(itemOrderForm.toDomain(totalPrice));
        }

        return domainItemOrderList;
    }

}
