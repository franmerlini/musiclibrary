package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.CustomerRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.CustomerRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.CustomerResponse;
import com.merlini.musiclibrary.domain.models.Customer;
import com.merlini.musiclibrary.ports.drivers.CustomerDriverPort;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerRestDriverAdapter {
  private final CustomerDriverPort customerDriverPort;
  private final CustomerRestMapper customerRestMapper;

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(
      @RequestBody @Valid CustomerRequest customerRequest) {
    Customer customer = customerRestMapper.toCustomer(customerRequest);
    Customer createdCustomer = customerDriverPort.createCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(customerRestMapper.toCustomerResponse(createdCustomer));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable int id) {
    Customer customer = customerDriverPort.getCustomerById(id);
    return ResponseEntity.ok(customerRestMapper.toCustomerResponse(customer));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable int id,
                                                         @RequestBody
                                                         @Valid CustomerRequest customerRequest) {
    Customer customer = customerRestMapper.toCustomer(customerRequest);
    Customer updatedCustomer = customerDriverPort.updateCustomer(id, customer);
    return ResponseEntity.ok(customerRestMapper.toCustomerResponse(updatedCustomer));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int id) {
    customerDriverPort.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
    List<Customer> customers = customerDriverPort.getAllCustomers();
    return ResponseEntity.ok(
        customers.stream().map(customerRestMapper::toCustomerResponse).toList());
  }
}
