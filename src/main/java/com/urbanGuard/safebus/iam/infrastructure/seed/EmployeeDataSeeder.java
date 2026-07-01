package com.urbanGuard.safebus.iam.infrastructure.seed;

import com.urbanGuard.safebus.iam.domain.model.aggregates.Employee;
import com.urbanGuard.safebus.iam.domain.model.commands.CreateEmployeeCommand;
import com.urbanGuard.safebus.iam.infrastructure.persistence.jpa.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Crea empleados de prueba al iniciar la aplicación,
 * solo si aún no existen en la base de datos. Así los códigos EMP-001..007
 * que se muestran en el panel admin realmente existen en el backend
 */
@Component
public class EmployeeDataSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public EmployeeDataSeeder(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        seedIfMissing("EMP-001", "Marcos E. Silva", "marcos.silva@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-002", "Juan Quispe", "juan.quispe@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-003", "Pedro Mamani", "pedro.mamani@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-004", "Miguel Flores", "miguel.flores@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-005", "Luis Ccama", "luis.ccama@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-006", "Carlos Huanca", "carlos.huanca@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("EMP-007", "Roberto Apaza", "roberto.apaza@safebus.com", "conductor123", "CONDUCTOR");
        seedIfMissing("ADM-001", "Administrador SafeBus", "admin@safebus.com", "admin123", "ADMIN");
    }

    private void seedIfMissing(String code, String fullName, String email, String password, String role) {
        if (!employeeRepository.existsByEmployeeCode(code)) {
            employeeRepository.save(new Employee(new CreateEmployeeCommand(code, fullName, email, password, role)));
        }
    }
}
