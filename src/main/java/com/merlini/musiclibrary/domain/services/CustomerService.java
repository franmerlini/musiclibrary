package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Customer;
import com.merlini.musiclibrary.ports.driven.CustomerDrivenPort;
import com.merlini.musiclibrary.ports.drivers.CustomerDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerService implements CustomerDriverPort {
  private final CustomerDrivenPort customerDrivenPort;

  @Override
  public Customer createCustomer(Customer customer) {
    return customerDrivenPort.createCustomer(customer);
  }

  @Override
  public Customer getCustomerById(Integer id) {
    return customerDrivenPort.getCustomerById(id);
  }

  @Override
  public Customer updateCustomer(Integer id, Customer customer) {
    return customerDrivenPort.updateCustomer(id, customer);
  }

  @Override
  public void deleteCustomer(Integer id) {
    customerDrivenPort.deleteCustomer(id);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customerDrivenPort.getAllCustomers();
  }
}
