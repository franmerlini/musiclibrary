package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.CustomerEntity;
import com.merlini.musiclibrary.domain.models.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerPersistenceMapper {
  CustomerEntity customerToCustomerEntity(Customer customer);

  Customer customerEntityToCustomer(CustomerEntity customerEntity);
}
