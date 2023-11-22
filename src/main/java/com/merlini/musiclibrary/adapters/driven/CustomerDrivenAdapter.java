package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.CustomerEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.CustomerPersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.CustomerRepository;
import com.merlini.musiclibrary.domain.models.Customer;
import com.merlini.musiclibrary.ports.driven.CustomerDrivenPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerDrivenAdapter implements CustomerDrivenPort {
  private final CustomerRepository customerRepository;
  private final CustomerPersistenceMapper customerPersistenceMapper;

  @Override
  public Customer createCustomer(Customer customer) {
    try {
      CustomerEntity customerEntity = customerPersistenceMapper.customerToCustomerEntity(customer);
      CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);

      return customerPersistenceMapper.customerEntityToCustomer(savedCustomerEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating customer.");
    }
  }

  @Override
  public Customer getCustomerById(Integer id) {
    try {
      Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

      if (customerEntity.isEmpty()) {
        throw new EntityNotFoundException("Customer not found.");
      }

      return customerPersistenceMapper.customerEntityToCustomer(customerEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting customer.");
    }
  }

  @Override
  public Customer updateCustomer(Integer id, Customer customer) {
    try {
      Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

      if (customerEntity.isEmpty()) {
        throw new EntityNotFoundException("Customer not found.");
      }

      CustomerEntity toUpdateCustomerEntity =
          customerPersistenceMapper.customerToCustomerEntity(customer);
      CustomerEntity updatedCustomerEntity = customerRepository.save(toUpdateCustomerEntity);

      return customerPersistenceMapper.customerEntityToCustomer(updatedCustomerEntity);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating customer.");
    }
  }

  @Override
  public void deleteCustomer(Integer id) {
    try {
      boolean exists = customerRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Customer not found.");
      }

      customerRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting customer.");
    }
  }

  @Override
  public List<Customer> getAllCustomers() {
    try {
      Iterable<CustomerEntity> customerEntities = customerRepository.findAll();

      return stream(customerEntities.spliterator(), false)
          .map(customerPersistenceMapper::customerEntityToCustomer)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all customers.");
    }
  }
}
