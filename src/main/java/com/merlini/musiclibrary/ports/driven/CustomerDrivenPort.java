package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Customer;
import java.util.List;

public interface CustomerDrivenPort {
  Customer createCustomer(Customer customer);

  Customer getCustomerById(Integer id);

  Customer updateCustomer(Integer id, Customer customer);

  void deleteCustomer(Integer id);

  List<Customer> getAllCustomers();
}
