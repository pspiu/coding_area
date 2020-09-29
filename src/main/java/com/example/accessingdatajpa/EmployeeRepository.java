package com.example.accessingdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
public List<Employee> findByRole(String role);
public Optional<Employee> findById(Long id);
}
