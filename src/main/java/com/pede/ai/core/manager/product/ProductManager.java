package com.pede.ai.core.manager.product;

import com.pede.ai.core.commons.enums.ProductType;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.IProductManager;
import com.pede.ai.core.ports.outbound.IProductRepositoryPort;

import java.util.List;

public class ProductManager implements IProductManager {

    private final IProductRepositoryPort iProductRepositoryPort;

    public ProductManager(IProductRepositoryPort iProductRepositoryPort) {
      this.iProductRepositoryPort = iProductRepositoryPort;
    }
    @Override
    public DomainProduct save(DomainProduct domainProduct) {
      return iProductRepositoryPort.save(domainProduct);
    }

    @Override
    public List<DomainProduct> getAll() {
      return iProductRepositoryPort.getAll();
    }

    @Override
    public DomainProduct getById(Long id) { return iProductRepositoryPort.getById(id); }

    @Override
    public DomainProduct update(Long id, DomainProduct domainProduct) { return iProductRepositoryPort.update(id, domainProduct); }

    @Override
    public String deleteById(Long id) { return iProductRepositoryPort.deleteById(id); }

    @Override
    public List<DomainProduct> getAllFromType(ProductType productType) { return iProductRepositoryPort.getAllFromType(productType); }

}
