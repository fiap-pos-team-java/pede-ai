package com.pede.ai.infra.outbounds;

import com.pede.ai.core.commons.enums.ProductType;
import com.pede.ai.infra.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByType(ProductType productType);
}
