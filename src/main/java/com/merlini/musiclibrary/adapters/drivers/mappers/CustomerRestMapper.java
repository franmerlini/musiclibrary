package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.CustomerRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.CustomerResponse;
import com.merlini.musiclibrary.domain.models.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerRestMapper {
  Customer toCustomer(CustomerRequest customerRequest);

  CustomerResponse toCustomerResponse(Customer customer);
}
