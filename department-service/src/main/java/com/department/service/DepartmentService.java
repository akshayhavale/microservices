package com.department.service;

import java.util.List;

import com.department.model.Department;

public interface DepartmentService {

	Department saveOrUpdate(Department department);

	Department getById(Long id);

	Department getByDepartmentName(String departmentName);

	Department getByDepartmentCode(String departmentCode);

	void delete(Long id);

	List<Department> getAll();

}
