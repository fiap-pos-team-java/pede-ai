package com.pede.ai.infra.commons.mappers;

import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.entities.ProductEntity;
import com.pede.ai.infra.inbounds.dtos.ProductDto;

public abstract class ProductMapper {

  public static ProductEntity toEntity(DomainProduct domainProduct) {
    return new ProductEntity(
            domainProduct.name(),
            domainProduct.desc(),
            domainProduct.price(),
            domainProduct.type(),
            domainProduct.createdAt()
          );
  }

  public static DomainProduct toDomain(ProductEntity productEntity) {
    return new DomainProduct(
            productEntity.id,
            productEntity.name,
            productEntity.desc,
            productEntity.price,
            productEntity.type,
            productEntity.createdAt
    );
  }

  public static ProductDto toDto(DomainProduct domainProduct) {
    return new ProductDto(
            domainProduct.id(),
            domainProduct.name(),
            domainProduct.desc(),
            domainProduct.price(),
            domainProduct.type(),
            domainProduct.createdAt()
    );
  }

}
