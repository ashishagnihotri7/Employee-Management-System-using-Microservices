package com.ashish.agnihotri.employee_service.client;

import com.ashish.agnihotri.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);

}