package com.ashish.agnihotri.employee_service.service;

import com.ashish.agnihotri.employee_service.client.APIClient;
import com.ashish.agnihotri.employee_service.dto.APIResponseDto;
import com.ashish.agnihotri.employee_service.dto.DepartmentDto;
import com.ashish.agnihotri.employee_service.dto.EmployeeDto;
import com.ashish.agnihotri.employee_service.entity.Employee;
import com.ashish.agnihotri.employee_service.exception.EmployeeResourceNotFoundException;
import com.ashish.agnihotri.employee_service.mapper.EmployeeMapper;
import com.ashish.agnihotri.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final APIClient apiClient;

    // Create Employee
    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // Get All Employees
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    // Get Employee By Id + Department Details (Feign call)
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeResourceNotFoundException("Employee id " + id + " not found"));

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = apiClient.getDepartmentById(employee.getDepartmentId());

        return new APIResponseDto(employeeDto, departmentDto);
    }

    // Update Employee
    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeResourceNotFoundException("Employee id " + id + " not found"));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setDepartmentId(employeeDto.getDepartmentId());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setSalary(employeeDto.getSalary());
        employee.setAddress(employeeDto.getAddress());
        employee.setJoiningDate(employeeDto.getJoiningDate());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    // Delete Employee
    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeResourceNotFoundException("Employee id " + id + " not found."));

        employeeRepository.delete(employee);
    }

    // Pagination
    @Override
    public Page<EmployeeDto> getAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size))
                .map(EmployeeMapper::mapToEmployeeDto);
    }
}