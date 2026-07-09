package com.ashish.agnihotri.department_service.mapper;

import com.ashish.agnihotri.department_service.dto.DepartmentDto;
import com.ashish.agnihotri.department_service.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto) {

        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentHead(),
                departmentDto.getLocation(),
                departmentDto.getEmployeeCount(),
                departmentDto.getContactEmail(),
                departmentDto.getStatus()
        );
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {

        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription(),
                department.getDepartmentHead(),
                department.getLocation(),
                department.getEmployeeCount(),
                department.getContactEmail(),
                department.getStatus()
        );
    }
}