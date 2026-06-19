package com.urbanGuard.safebus.iam.application.internal.commandservices;

import com.urbanGuard.safebus.iam.application.commandservices.EmployeeCommandService;
import com.urbanGuard.safebus.iam.domain.model.aggregates.Employee;
import com.urbanGuard.safebus.iam.domain.model.commands.CreateEmployeeCommand;
import com.urbanGuard.safebus.iam.infrastructure.persistence.jpa.EmployeeRepository;
import com.urbanGuard.safebus.shared.application.result.Result;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCommandServiceImpl implements EmployeeCommandService {

    private final EmployeeRepository employeeRepository;

    public EmployeeCommandServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Result<Employee, String> handle(CreateEmployeeCommand command) {
        if (employeeRepository.existsByEmployeeCode(command.employeeCode())) {
            return Result.err("Employee code already exists: " + command.employeeCode());
        }
        if (employeeRepository.existsByEmail(command.email())) {
            return Result.err("Email already in use: " + command.email());
        }
        var employee = new Employee(command);
        employeeRepository.save(employee);
        return Result.ok(employee);
    }
}
