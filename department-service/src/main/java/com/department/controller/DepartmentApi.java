package com.department.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.DepartmentDto;
import com.department.mapper.DepartmentMapper;
import com.department.model.Department;
import com.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentApi.class);

	private static final String MESSAGE = "ENTERED DEPARTMENT CONTROLLER";

	@Autowired
	private DepartmentService departmentService;

	@PostMapping(value = "/create")
	public DepartmentDto save(@RequestBody DepartmentDto department) {
		LOGGER.info(MESSAGE);
		Department departmentEntity = DepartmentMapper.INSTANCE.dtoToEntity(department);
		Department savedEntity = departmentService.saveOrUpdate(departmentEntity);
		return DepartmentMapper.INSTANCE.entityToDto(savedEntity);
	}

	@PutMapping(value = "/udpate/{id}")
	public DepartmentDto udpate(@RequestBody DepartmentDto department, @PathVariable(value = "id") Long id) {
		LOGGER.info(MESSAGE);
		Department check = departmentService.getById(id);

		if (check == null) {
			throw new ServiceException("Department not found for the id : " + id);
		}
		department.setId(id);
		Department departmentEntity = DepartmentMapper.INSTANCE.dtoToEntity(department);
		Department savedEntity = departmentService.saveOrUpdate(departmentEntity);
		return DepartmentMapper.INSTANCE.entityToDto(savedEntity);
	}

	@GetMapping(value = "/id/{id}")
	public DepartmentDto getById(@PathVariable(value = "id") Long id) {
		LOGGER.info(MESSAGE);
		Department department = departmentService.getById(id);
		return DepartmentMapper.INSTANCE.entityToDto(department);
	}

	@GetMapping(value = "/code/{code}")
	public DepartmentDto getByDepartmentCode(@PathVariable(value = "code") String code) {
		LOGGER.info(MESSAGE);
		Department department = departmentService.getByDepartmentCode(code);
		return DepartmentMapper.INSTANCE.entityToDto(department);
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<DepartmentDto> getByDepartmentName(@PathVariable(value = "name") String name) {
		LOGGER.info(MESSAGE);
		Department department = null;
		try {
			department = departmentService.getByDepartmentName(name);
		} catch (EntityNotFoundException e) {
			LOGGER.error("No Department Found for departmnet name : {}", name);
		}
		if (department == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		DepartmentDto dto = DepartmentMapper.INSTANCE.entityToDto(department);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public List<DepartmentDto> getAll() {
		LOGGER.info(MESSAGE);
		List<Department> departments = departmentService.getAll();
		List<DepartmentDto> dtos = new ArrayList<>();
		departments.stream().forEach(department -> {
			DepartmentDto dto = DepartmentMapper.INSTANCE.entityToDto(department);
			dtos.add(dto);
		});
		return dtos;
	}

	@DeleteMapping(value = "/id/{id}")
	public void deleteById(@PathVariable(value = "id") Long id) {
		LOGGER.info(MESSAGE);
		departmentService.delete(id);
	}
}
