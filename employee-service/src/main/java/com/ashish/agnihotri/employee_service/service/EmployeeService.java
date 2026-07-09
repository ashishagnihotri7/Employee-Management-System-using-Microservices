package com.ashish.agnihotri.employee_service.service;

import com.ashish.agnihotri.employee_service.dto.APIResponseDto;
import com.ashish.agnihotri.employee_service.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createNewEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    APIResponseDto getEmployeeById(Long id);

    EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);

    // PAGINATION
    Page<EmployeeDto> getAllEmployees(int page, int size);
}