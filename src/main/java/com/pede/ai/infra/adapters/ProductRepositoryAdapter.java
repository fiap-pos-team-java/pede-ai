package com.pede.ai.infra.adapters;

import com.pede.ai.core.commons.enums.ProductType;
import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.exceptions.CommitException;
import com.pede.ai.core.exceptions.NotFoundException;
import com.pede.ai.core.ports.outbound.IProductRepositoryPort;
import com.pede.ai.infra.commons.mappers.ProductMapper;
import com.pede.ai.infra.entities.ProductEntity;
import com.pede.ai.infra.outbounds.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static com.pede.ai.infra.commons.mappers.ProductMapper.toDomain;

@Service
public class ProductRepositoryAdapter implements IProductRepositoryPort {

  @Autowired
  private IProductRepository productRepository;

  @Override
  public DomainProduct save(DomainProduct domainProduct) {
    return Stream.of(domainProduct)
            .map(ProductMapper::toEntity)
            .map(productEntity -> productRepository.save(productEntity))
            .map(ProductMapper::toDomain)
            .findFirst()
            .orElseThrow(() -> new CommitException(String.format("The product %s entity can not be saved", domainProduct.name())));
  }

  @Override
  public List<DomainProduct> getAll() {
    return productRepository.findAll().stream()
            .map(ProductMapper::toDomain)
            .toList();
  }

  @Override
  public DomainProduct getById(Long id) {
    return productRepository.findById(id)
            .stream()
            .map(ProductMapper::toDomain)
            .findFirst()
            .orElseThrow(() -> new NotFoundException(String.format("ID %s not found", id)));
  }

  @Override
  public DomainProduct update(Long id, DomainProduct domainProduct) {
    DomainProduct product = toDomain(productRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("ID %s not found", id))));

    ProductEntity entity = new ProductEntity(
            id,
            domainProduct.name() != null ? domainProduct.name() : product.name(),
            domainProduct.desc() != null ? domainProduct.desc() : product.desc(),
            !domainProduct.price().equals(BigDecimal.valueOf(0)) ? domainProduct.price() : product.price(),
            domainProduct.type() != null ? domainProduct.type() : product.type(),
            product.createdAt()
    );

    productRepository.save(entity);
    return toDomain(entity);
  }

//  @Override
//  public String deleteById(Long id) {
//    if (productRepository.existsById(id)) {
//      productRepository.deleteById(id);
//        return "Product deleted successfully";
//    }
//    throw new NotFoundException(String.format("ID %s not found", id));
//  }

  @Override
  public String deleteById(Long id) {
    return productRepository.findById(id)
            .map(product -> {
              productRepository.delete(product);
              return "Product deleted successfully";
            })
            .orElseThrow(() -> new NotFoundException(String.format("ID %s not found", id)));
  }

  @Override
  public List<DomainProduct> getAllFromType(ProductType productType) {
    return productRepository.findByType(productType)
            .stream()
            .map(ProductMapper::toDomain)
            .toList();
  }

}