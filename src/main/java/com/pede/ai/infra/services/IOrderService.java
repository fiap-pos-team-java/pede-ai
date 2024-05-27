package com.pede.ai.infra.services;

import com.pede.ai.infra.inbounds.dtos.OrderDto;
import com.pede.ai.infra.inbounds.forms.OrderForm;

public interface IOrderService {
    OrderDto formToDto(OrderForm orderForm);
}
