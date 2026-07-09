package com.ashish.agnihotri.department_service.service;
import com.ashish.agnihotri.department_service.dto.DepartmentDto;
import com.ashish.agnihotri.department_service.entity.Department;
import com.ashish.agnihotri.department_service.exception.DepartmentNotFoundException;
import com.ashish.agnihotri.department_service.mapper.DepartmentMapper;
import com.ashish.agnihotri.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
    @Override
    public DepartmentDto getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return DepartmentMapper.mapToDepartmentDto(department);
    }
    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .toList();
    }
    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentHead(departmentDto.getDepartmentHead());
        department.setLocation(departmentDto.getLocation());
        department.setEmployeeCount(departmentDto.getEmployeeCount());
        department.setContactEmail(departmentDto.getContactEmail());
        department.setStatus(departmentDto.getStatus());

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }
    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));

        departmentRepository.delete(department);
    }
}