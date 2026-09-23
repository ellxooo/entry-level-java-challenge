package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

/**
 * EmployeeService
 * Business logic for managing Employees. Backed by an in-memory store for this challenge.
 */
public interface EmployeeService {

    /**
     * @return every Employee that is currently in the store.
     */
    List<Employee> getAllEmployees();

    /**
     * @param uuid the Employee's unique identifier
     * @return the matching Employee. Return null if none exists.
     */
    Employee getEmployeeByUuid(UUID uuid);

    /**
     * @param employee a fully-populated Employee to persist (uuid may be null; the service should assign one)
     * @return the newly created Employee along with its uuid set.
     */
    Employee createEmployee(Employee employee);
}
