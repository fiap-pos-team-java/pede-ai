package com.pede.ai.core.ports.inbound;

import com.pede.ai.core.commons.enums.ProductType;
import com.pede.ai.core.domain.product.DomainProduct;

import java.util.List;

public interface IProductManager {

    DomainProduct save(DomainProduct domainProduct);
    List<DomainProduct> getAll();
    DomainProduct getById(Long id);
    DomainProduct update(Long id, DomainProduct domainProduct);
    String deleteById(Long id);
    List<DomainProduct> getAllFromType(ProductType productType);

}
