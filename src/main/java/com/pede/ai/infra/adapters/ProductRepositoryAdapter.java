package com.pede.ai.infra.adapters;

import com.pede.ai.core.domain.product.DomainProduct;
import com.pede.ai.core.exceptions.CommitException;
import com.pede.ai.core.exceptions.NotFoundException;
import com.pede.ai.core.ports.outbound.IProductRepositoryPort;
import com.pede.ai.infra.commons.ErrorMessage;
import com.pede.ai.infra.commons.mappers.ProductMapper;
import com.pede.ai.infra.outbounds.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

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
            .orElseThrow(() -> new CommitException("The Product entity can not be saved"));
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
  public String deleteById(Long id) {
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);
      return "Produto deletado com sucesso.";
    }
    throw new NotFoundException(String.format("ID %s not found", id));
  }

}