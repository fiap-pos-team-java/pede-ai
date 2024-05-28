package com.pede.ai.infra.inbounds;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.IOrderManager;
import com.pede.ai.infra.adapters.ProductRepositoryAdapter;
import com.pede.ai.infra.inbounds.dtos.OrderDto;
import com.pede.ai.infra.inbounds.forms.ItemOrderForm;
import com.pede.ai.infra.inbounds.forms.OrderForm;
import com.pede.ai.infra.commons.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

  @Autowired
  private IOrderManager orderManager;

  @Autowired
  private ProductRepositoryAdapter productRepositoryAdapter;

  @PostMapping("/")
  public ResponseEntity<OrderDto> sendOrder(
    @RequestBody OrderForm orderForm
  ) {
    List<ItemOrderForm> itemOrderFormList = orderForm.productList();
    List<DomainItemOrder> domainItemOrdeList = new ArrayList<>();
    for(ItemOrderForm itemOrderForm : itemOrderFormList) {
      int amount = itemOrderForm.amount();
      DomainProduct product = productRepositoryAdapter.getById(itemOrderForm.productId());
      BigDecimal totalPrice = BigDecimal.valueOf(amount).multiply(product.price()) ;
      domainItemOrdeList.add(itemOrderForm.toDomain(totalPrice));
    }

    OrderDto orderDto = OrderMapper.toDto(orderManager.save(orderForm.toDomain(domainItemOrdeList)));
    return ResponseEntity.ok().body(orderDto);
  }

}
