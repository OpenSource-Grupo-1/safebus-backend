package com.urbanGuard.safebus.iam.domain.model.aggregates;

import com.urbanGuard.safebus.iam.domain.model.commands.CreateEmployeeCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String employeeCode;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // CONDUCTOR, ADMIN

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Instant updatedAt;

    protected Employee() {}

    public Employee(CreateEmployeeCommand command) {
        this.employeeCode = command.employeeCode();
        this.fullName = command.fullName();
        this.email = command.email();
        this.password = command.password();
        this.role = command.role();
    }
}
