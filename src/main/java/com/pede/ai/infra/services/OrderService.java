package com.pede.ai.infra.services;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.order.DomainOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.ICustomerManager;
import com.pede.ai.infra.inbounds.dtos.ItemOrderDto;
import com.pede.ai.infra.inbounds.dtos.OrderDto;
import com.pede.ai.infra.inbounds.forms.ItemOrderForm;
import com.pede.ai.infra.inbounds.forms.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private ICustomerManager custumerManager;

    @Autowired
    private IProductService productService;

    public OrderDto formToDto(OrderForm orderForm) {
        return new OrderDto(
                null,
                orderForm.status(),
                custumerManager.getByCpf(orderForm.custumerCpf()),
                createItemOrder(orderForm),
                LocalDateTime.now()
        );
    }

    private List<ItemOrderDto> createItemOrder(OrderForm orderForm) {
        List<ItemOrderDto> itemOrderList = new ArrayList<>();

        List<Long> productsId = new ArrayList<>();
        for(ItemOrderForm item : orderForm.productList()) {
            productsId.add(item.productId());
        }
        List<DomainProduct> domainProductList = productService.findProducts(productsId);

        for(ItemOrderForm item : orderForm.productList()) {
            for(DomainProduct domainProduct : domainProductList) {
                int amount = item.amount();
                BigDecimal totalPrice = BigDecimal.valueOf(amount).multiply(domainProduct.price());
                ItemOrderDto domainItemOrder = new ItemOrderDto(
                        null,
                        totalPrice,
                        amount,
                        domainProduct,
                        LocalDateTime.now()
                );

                itemOrderList.add(domainItemOrder);
            }
        }

        return itemOrderList;
    }

}
