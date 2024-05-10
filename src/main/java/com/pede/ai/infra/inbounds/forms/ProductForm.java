package com.pede.ai.infra.inbounds.forms;

import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.infra.commons.enums.ProductType;

import java.time.LocalDateTime;

public record ProductForm(
    String name,
    String desc,
    float price,
    ProductType type
) {

  public DomainProduct toDomain() {
    return
      new DomainProduct(
    null,
        this.name,
        this.desc,
        this.price, 
        this.type,
        LocalDateTime.now()
      );
  }

}
