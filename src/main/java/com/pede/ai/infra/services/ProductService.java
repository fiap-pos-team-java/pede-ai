package com.pede.ai.infra.services;

import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.ports.inbound.IProductManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    private IProductManager productManager;

    public List<DomainProduct> findProducts(List<Long> productsId) {
        List<DomainProduct> domainProductList = new ArrayList<>();

        for(Long product : productsId) {
            domainProductList.add(productManager.getById(product));
        }

        return domainProductList;
    }

}
