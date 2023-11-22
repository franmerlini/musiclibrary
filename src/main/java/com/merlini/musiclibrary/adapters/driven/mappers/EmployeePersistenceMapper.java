package com.merlini.musiclibrary.adapters.driven.mappers;

import com.merlini.musiclibrary.adapters.driven.entities.EmployeeEntity;
import com.merlini.musiclibrary.domain.models.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeePersistenceMapper {
  EmployeeEntity employeeToEmployeeEntity(Employee employee);

  Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);
}
