package com.pede.ai.infra.inbounds;

import com.pede.ai.core.commons.enums.ProductType;
import com.pede.ai.core.ports.inbound.IProductManager;
import com.pede.ai.infra.commons.mappers.ProductMapper;
import com.pede.ai.infra.inbounds.dtos.ProductDto;
import com.pede.ai.infra.inbounds.forms.ProductForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private IProductManager productManager;

  @PostMapping("/")
  public ResponseEntity<ProductDto> saveProduct(
    @RequestBody ProductForm productForm
  ) {
    ProductDto productDto = ProductMapper.toDto(
            productManager.save(productForm.toDomain()));

    return ResponseEntity.ok().body(productDto);
  }

  @GetMapping("/")
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    List<ProductDto> products = productManager.getAll().stream()
            .map(ProductMapper::toDto)
            .toList();

    return ResponseEntity.ok().body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(
          @PathVariable(value="id") Long id
  ) {
    ProductDto product = ProductMapper.toDto(productManager.getById(id));

    return ResponseEntity.ok().body(product);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<ProductDto> updateProductById(
          @PathVariable(value="id") Long id,
          @Valid @RequestBody ProductForm productForm
  ) {
    ProductDto productDto = ProductMapper.toDto(productManager.update(id, productForm.toDomain()));

    return ResponseEntity.ok().body(productDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProductById(
          @PathVariable(value="id") Long id
  ) {
    return ResponseEntity.ok().body(productManager.deleteById(id));
  }

  @GetMapping("/category/{type}")
  public ResponseEntity<List<ProductDto>> getProductsByType(
          @PathVariable(value="type") ProductType type
  ) {
    List<ProductDto> products = productManager.getAllFromType(type).stream()
            .map(ProductMapper::toDto)
            .toList();

    return ResponseEntity.ok().body(products);
  }

}
