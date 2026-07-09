package com.ashish.agnihotri.employee_service.controller;

import com.ashish.agnihotri.employee_service.dto.APIResponseDto;
import com.ashish.agnihotri.employee_service.dto.EmployeeDto;
import com.ashish.agnihotri.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(
            @Valid @RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.createNewEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get All Employees
    @GetMapping("/details")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get Employee By Id + Department Details
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(
            @PathVariable Long id) {

        APIResponseDto response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployeeById(id, employeeDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable Long id) {

        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

    // Pagination
    @GetMapping("/details/page")
    public ResponseEntity<Page<EmployeeDto>> getPage(
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(
                employeeService.getAllEmployees(page, size)
        );
    }
}