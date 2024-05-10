package com.pede.ai.core.ports.outbound;

import com.pede.ai.core.domain.product.DomainProduct;

import java.util.List;

public interface IProductRepositoryPort {
    DomainProduct save(DomainProduct domainProduct);
    List<DomainProduct> getAll();
    DomainProduct getById(Long id);
    String deleteById(Long id);
}
