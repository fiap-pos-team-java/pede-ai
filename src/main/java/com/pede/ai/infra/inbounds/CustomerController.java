package com.pede.ai.infra.inbounds;

import com.pede.ai.core.ports.inbound.ICustomerManager;
import com.pede.ai.infra.commons.mappers.CustomerMapper;
import com.pede.ai.infra.inbounds.dtos.CustomerDto;
import com.pede.ai.infra.inbounds.forms.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  @Autowired
  private ICustomerManager customerManager;

  @PostMapping("/")
  public ResponseEntity<CustomerDto> saveCustomer(
    @RequestBody CustomerForm customerForm
  ) {
    CustomerDto customerDto = CustomerMapper.toDto(
            customerManager.save(customerForm.toDomain()));

    return ResponseEntity.ok().body(customerDto);
  }

  @GetMapping("/")
  public ResponseEntity<List<CustomerDto>> getAllCustomers() {
    List<CustomerDto> customers = customerManager.getAll().stream()
            .map(CustomerMapper::toDto)
            .toList();

    return ResponseEntity.ok().body(customers);
  }

  @GetMapping("/{cpf}")
  public ResponseEntity<CustomerDto> getCustomerByCpf(@PathVariable(value="cpf") String cpf) {
    CustomerDto customer = CustomerMapper.toDto(customerManager.getByCpf(cpf));

    return ResponseEntity.ok().body(customer);
  }

}
