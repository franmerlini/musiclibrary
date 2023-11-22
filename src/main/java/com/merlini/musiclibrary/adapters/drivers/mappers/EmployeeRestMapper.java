package com.merlini.musiclibrary.adapters.drivers.mappers;

import com.merlini.musiclibrary.adapters.drivers.requests.EmployeeRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.EmployeeResponse;
import com.merlini.musiclibrary.domain.models.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeRestMapper {
  Employee toEmployee(EmployeeRequest employeeRequest);

  EmployeeResponse toEmployeeResponse(Employee employee);
}
