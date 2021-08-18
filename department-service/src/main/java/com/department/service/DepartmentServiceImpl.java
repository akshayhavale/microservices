package com.department.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.model.Department;
import com.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveOrUpdate(Department department) {
		LOGGER.info("ENTERED DEPARTMENT SERVICE SAVE OR UPDATE METHOD");
		return departmentRepository.save(department);
	}

	@Override
	public Department getById(Long id) {
		LOGGER.info("ENTERED DEPARTMENT SERVICE GETBYID METHOD");
		return departmentRepository.getById(id);
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("ENTERED DEPARTMENT SERVICE DELETEBYID METHOD");
		departmentRepository.deleteById(id);
		LOGGER.info("DEPARTMENT DELETED SUCCESFULLY");

	}

	@Override
	public List<Department> getAll() {
		LOGGER.info("ENTERED DEPARTMENT SERVICE GETALL METHOD");
		return departmentRepository.findAll();
	}

	@Override
	public Department getByDepartmentName(String departmentName) {
		LOGGER.info("ENTERED DEPARTMENT SERVICE GETBYDEPARTMENTNAME METHOD");
		return departmentRepository.findByDepartmentName(departmentName);
	}

	@Override
	public Department getByDepartmentCode(String departmentCode) {
		LOGGER.info("ENTERED DEPARTMENT SERVICE GET BY DEPARTMENT CODE METHOD");
		return departmentRepository.findByDepartmentCode(departmentCode);
	}

}
