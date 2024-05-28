package com.pede.ai.infra.inbounds;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.IOrderManager;
import com.pede.ai.infra.adapters.ProductRepositoryAdapter;
import com.pede.ai.infra.commons.mappers.ProductMapper;
import com.pede.ai.infra.inbounds.dtos.OrderDto;
import com.pede.ai.infra.inbounds.dtos.ProductDto;
import com.pede.ai.infra.inbounds.forms.ItemOrderForm;
import com.pede.ai.infra.inbounds.forms.OrderForm;
import com.pede.ai.infra.commons.mappers.OrderMapper;
import com.pede.ai.infra.services.IOrderService;
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
  private IOrderService orderService;

  @PostMapping("/")
  public ResponseEntity<OrderDto> sendOrder(
    @RequestBody OrderForm orderForm
  ) {
    OrderDto orderDto = OrderMapper.toDto(
            orderManager.save(orderForm.toDomain(orderService.convertDomainItemOrder(orderForm.productList()))));

    return ResponseEntity.ok().body(orderDto);
  }

  @GetMapping("/")
  public ResponseEntity<List<OrderDto>> getAllOrders() {
    List<OrderDto> orders = orderManager.getAll().stream()
            .map(OrderMapper::toDto)
            .toList();

    return ResponseEntity.ok().body(orders);
  }

}
