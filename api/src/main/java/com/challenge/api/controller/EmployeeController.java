package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.MockEmployee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * EmployeeController
 * REST controller exposing Employee data for consumption by external services.
 * Delegates all business logic to {@link EmployeeService}; this class is only
 * responsible for HTTP-layer concerns such as routing, status codes,
 * request/response mapping.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @return one or more Employees currently known to the service. The employees are held
     * in memory rather than a real persistent layer dedicated for storing info.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * @param uuid Employee UUID.
     * @return Requested Employee if exists.
     */
    @GetMapping("/{uuid}")
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        Employee employee = employeeService.getEmployeeByUuid(uuid);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return employee;
        }
    }

    /**
     * @param MockEmployee the employee data to create.
     * @return newly created Employee.
     */
    @PostMapping
    public Employee createEmployee(@RequestBody MockEmployee mockEmployee) {
        return employeeService.createEmployee(mockEmployee);
    }
}
