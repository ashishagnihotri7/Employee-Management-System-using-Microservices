package com.ashish.agnihotri.department_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    @NotBlank(message = "Department name is required")
    private String departmentName;

    @NotBlank(message = "Department code is required")
    private String departmentCode;

    private String departmentDescription;

    @NotBlank(message = "Department head is required")
    private String departmentHead;

    @NotBlank(message = "Location is required")
    private String location;

    private Integer employeeCount;

    @Email(message = "Enter a valid email")
    private String contactEmail;

    private String status;
}