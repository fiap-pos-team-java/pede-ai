package com.pede.ai.infra.outbounds;

import com.pede.ai.infra.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
