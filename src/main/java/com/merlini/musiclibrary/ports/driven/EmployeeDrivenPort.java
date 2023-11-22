package com.merlini.musiclibrary.ports.driven;

import com.merlini.musiclibrary.domain.models.Employee;
import java.util.List;

public interface EmployeeDrivenPort {
  Employee createEmployee(Employee employee);

  Employee getEmployeeById(Integer id);

  Employee updateEmployee(Integer id, Employee employee);

  void deleteEmployee(Integer id);

  List<Employee> getAllEmployees();
}
