package com.merlini.musiclibrary.domain.services;

import com.merlini.musiclibrary.domain.models.Employee;
import com.merlini.musiclibrary.ports.driven.EmployeeDrivenPort;
import com.merlini.musiclibrary.ports.drivers.EmployeeDriverPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeService implements EmployeeDriverPort {
  private final EmployeeDrivenPort employeeDrivenPort;

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeDrivenPort.createEmployee(employee);
  }

  @Override
  public Employee getEmployeeById(Integer id) {
    return employeeDrivenPort.getEmployeeById(id);
  }

  @Override
  public Employee updateEmployee(Integer id, Employee employee) {
    return employeeDrivenPort.updateEmployee(id, employee);
  }

  @Override
  public void deleteEmployee(Integer id) {
    employeeDrivenPort.deleteEmployee(id);
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeDrivenPort.getAllEmployees();
  }
}
