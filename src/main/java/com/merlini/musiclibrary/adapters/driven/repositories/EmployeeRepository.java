package com.merlini.musiclibrary.adapters.driven.repositories;

import com.merlini.musiclibrary.adapters.driven.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
