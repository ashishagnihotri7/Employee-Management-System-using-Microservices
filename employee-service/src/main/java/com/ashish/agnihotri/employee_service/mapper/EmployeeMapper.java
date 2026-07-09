package com.ashish.agnihotri.employee_service.mapper;

import com.ashish.agnihotri.employee_service.dto.EmployeeDto;
import com.ashish.agnihotri.employee_service.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartmentId(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getAddress(),
                employee.getJoiningDate()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                employeeDto.getDepartmentId(),
                employeeDto.getDesignation(),
                employeeDto.getSalary(),
                employeeDto.getAddress(),
                employeeDto.getJoiningDate()
        );
    }
}