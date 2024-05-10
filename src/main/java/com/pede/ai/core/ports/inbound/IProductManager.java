package com.pede.ai.core.ports.inbound;

import com.pede.ai.core.domain.product.DomainProduct;

import java.util.List;

public interface IProductManager {

    DomainProduct save(DomainProduct domainProduct);
    List<DomainProduct> getAll();
    DomainProduct getById(Long id);

}
