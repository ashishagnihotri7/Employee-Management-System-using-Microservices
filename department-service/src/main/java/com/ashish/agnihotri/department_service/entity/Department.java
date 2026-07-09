package com.ashish.agnihotri.department_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is required")
    @Column(nullable = false, unique = true)
    private String departmentName;

    @NotBlank(message = "Department code is required")
    @Column(nullable = false, unique = true)
    private String departmentCode;

    @Column(length = 500)
    private String departmentDescription;

    @NotBlank(message = "Department head is required")
    @Column(nullable = false)
    private String departmentHead;

    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer employeeCount;

    @Email(message = "Enter a valid email")
    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String status;
}