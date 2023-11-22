package com.merlini.musiclibrary.adapters.driven;

import static java.util.stream.StreamSupport.stream;

import com.merlini.musiclibrary.adapters.driven.entities.EmployeeEntity;
import com.merlini.musiclibrary.adapters.driven.exceptions.EmployeeSelfSupervisor;
import com.merlini.musiclibrary.adapters.driven.exceptions.EntityNotFoundException;
import com.merlini.musiclibrary.adapters.driven.mappers.EmployeePersistenceMapper;
import com.merlini.musiclibrary.adapters.driven.repositories.EmployeeRepository;
import com.merlini.musiclibrary.domain.models.Employee;
import com.merlini.musiclibrary.ports.driven.EmployeeDrivenPort;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeDrivenAdapter implements EmployeeDrivenPort {
  private final EmployeeRepository employeeRepository;
  private final EmployeePersistenceMapper employeePersistenceMapper;

  @Override
  public Employee createEmployee(Employee employee) {
    try {
      EmployeeEntity employeeEntity = employeePersistenceMapper.employeeToEmployeeEntity(employee);
      EmployeeEntity savedEmployeeEntity = this.employeeRepository.save(employeeEntity);

      return employeePersistenceMapper.employeeEntityToEmployee(savedEmployeeEntity);
    } catch (Exception e) {
      throw new RuntimeException("Error while creating employee.");
    }
  }

  @Override
  public Employee getEmployeeById(Integer id) {
    try {
      Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);

      if (employeeEntity.isEmpty()) {
        throw new EntityNotFoundException("Employee not found.");
      }

      return employeePersistenceMapper.employeeEntityToEmployee(employeeEntity.get());
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while getting employee.");
    }
  }

  @Override
  public Employee updateEmployee(Integer id, Employee employee) {
    try {
      Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);

      if (employeeEntity.isEmpty()) {
        throw new EntityNotFoundException("Employee not found.");
      }

      if (employee.getSupervisor() != null) {
        boolean exists = this.employeeRepository.existsById(employee.getSupervisor().getId());

        if (!exists) {
          throw new EntityNotFoundException("Supervisor not found.");
        }

        if (Objects.equals(employee.getSupervisor().getId(), id)) {
          throw new EmployeeSelfSupervisor();
        }
      }

      EmployeeEntity toUpdateEmployeeEntity = patchEmployee(employeeEntity.get(), employee);
      EmployeeEntity updatedEmployeeEntity = this.employeeRepository.save(toUpdateEmployeeEntity);

      return employeePersistenceMapper.employeeEntityToEmployee(updatedEmployeeEntity);
    } catch (EntityNotFoundException | EmployeeSelfSupervisor e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while updating employee.");
    }
  }

  @Override
  public void deleteEmployee(Integer id) {
    try {
      boolean exists = this.employeeRepository.existsById(id);

      if (!exists) {
        throw new EntityNotFoundException("Employee not found.");
      }

      this.employeeRepository.deleteById(id);
    } catch (EntityNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error while deleting employee.");
    }
  }

  @Override
  public List<Employee> getAllEmployees() {
    try {
      Iterable<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();

      return stream(employeeEntities.spliterator(), false)
          .map(employeePersistenceMapper::employeeEntityToEmployee)
          .toList();
    } catch (Exception e) {
      throw new RuntimeException("Error while getting all employees.");
    }
  }

  private EmployeeEntity patchEmployee(EmployeeEntity employeeEntity, Employee employee) {
    if (employee.getLastName() != null) {
      employeeEntity.setLastName(employee.getLastName());
    }

    if (employee.getFirstName() != null) {
      employeeEntity.setFirstName(employee.getFirstName());
    }

    if (employee.getTitle() != null) {
      employeeEntity.setTitle(employee.getTitle());
    }

    if (employee.getSupervisor() != null) {
      employeeEntity.getSupervisor().setId(employee.getSupervisor().getId());
    }

    if (employee.getBirthDate() != null) {
      employeeEntity.setBirthDate(employee.getBirthDate());
    }

    if (employee.getHireDate() != null) {
      employeeEntity.setHireDate(employee.getHireDate());
    }

    if (employee.getAddress() != null) {
      employeeEntity.setAddress(employee.getAddress());
    }

    if (employee.getCity() != null) {
      employeeEntity.setCity(employee.getCity());
    }

    if (employee.getState() != null) {
      employeeEntity.setState(employee.getState());
    }

    if (employee.getCountry() != null) {
      employeeEntity.setCountry(employee.getCountry());
    }

    if (employee.getPostalCode() != null) {
      employeeEntity.setPostalCode(employee.getPostalCode());
    }

    if (employee.getPhone() != null) {
      employeeEntity.setPhone(employee.getPhone());
    }

    if (employee.getFax() != null) {
      employeeEntity.setFax(employee.getFax());
    }

    if (employee.getEmail() != null) {
      employeeEntity.setEmail(employee.getEmail());
    }

    return employeeEntity;
  }
}
