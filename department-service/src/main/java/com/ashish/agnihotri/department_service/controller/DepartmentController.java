package com.ashish.agnihotri.department_service.controller;

import com.ashish.agnihotri.department_service.dto.DepartmentDto;
import com.ashish.agnihotri.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){

        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);

        return ResponseEntity.ok(departmentDto);

    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

        List<DepartmentDto> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(
            @PathVariable("id") Long departmentId,
            @RequestBody DepartmentDto departmentDto) {

        DepartmentDto updatedDepartment =
                departmentService.updateDepartment(departmentId, departmentDto);

        return ResponseEntity.ok(updatedDepartment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(
            @PathVariable("id") Long departmentId) {

        departmentService.deleteDepartment(departmentId);

        return ResponseEntity.ok("Department deleted successfully.");
    }
}