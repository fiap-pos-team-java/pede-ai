package com.pede.ai.infra.services;

import com.pede.ai.core.domain.order.DomainItemOrder;
import com.pede.ai.core.domain.product.DomainProduct;

import java.util.List;
import java.util.Set;

public interface IProductService {
    List<DomainProduct> findProducts(List<Long> productsId);
}
