package com.merlini.musiclibrary.adapters.drivers;

import com.merlini.musiclibrary.adapters.drivers.mappers.EmployeeRestMapper;
import com.merlini.musiclibrary.adapters.drivers.requests.EmployeeRequest;
import com.merlini.musiclibrary.adapters.drivers.responses.EmployeeResponse;
import com.merlini.musiclibrary.domain.models.Employee;
import com.merlini.musiclibrary.ports.drivers.EmployeeDriverPort;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/api/employees")
public class EmployeeRestDriverAdapter {
  private final EmployeeDriverPort employeeDriverPort;
  private final EmployeeRestMapper employeeRestMapper;

  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(
      @RequestBody @Valid EmployeeRequest employeeRequest) {
    Employee employee = employeeRestMapper.toEmployee(employeeRequest);
    Employee createdEmployee = employeeDriverPort.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(employeeRestMapper.toEmployeeResponse(createdEmployee));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
    Employee employee = employeeDriverPort.getEmployeeById(id);
    return ResponseEntity.ok(employeeRestMapper.toEmployeeResponse(employee));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<EmployeeResponse> updateEmployee(
      @PathVariable int id,
      @RequestBody @Validated(EmployeeRequest.PatchEmployeeRequest.class)
      EmployeeRequest employeeRequest
  ) {
    Employee employee = employeeRestMapper.toEmployee(employeeRequest);
    Employee updatedEmployee = employeeDriverPort.updateEmployee(id, employee);
    return ResponseEntity.ok(employeeRestMapper.toEmployeeResponse(updatedEmployee));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable int id) {
    employeeDriverPort.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
    List<Employee> employees = employeeDriverPort.getAllEmployees();
    return ResponseEntity.ok(
        employees.stream().map(employeeRestMapper::toEmployeeResponse).toList());
  }
}
