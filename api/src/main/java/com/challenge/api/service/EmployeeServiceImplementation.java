package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * EmployeeServiceImplementation
 * Business implementation for EmployeeService.
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

    // NOTE: HashMap is not thread-safe. Would use ConcurrentHashMap instead in
    // a multi-threaded environment to handle multiple requests simultaneously.
    private final Map<UUID, Employee> employeeStore = new HashMap<>();
    /**
     *
     * @return every Employee.
     */
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    /**
     *
     * @param uuid the Employee's unique identifier.
     * @return the matching Employee. Return null if none exists.
     */
    public Employee getEmployeeByUuid(UUID uuid) {
        return employeeStore.get(uuid);
    }

    /**
     *
     * @param employee the employee data to persist.
     * @return the newly created Employee, with its uuid populated.
     */
    public Employee createEmployee(Employee employee) {
        UUID uuid = UUID.randomUUID();
        employee.setUuid(uuid);
        employeeStore.put(uuid, employee);
        return employee;
    }
}
