package com.ashish.agnihotri.employee_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "designation", nullable = false, length = 50)
    private String designation;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;
}