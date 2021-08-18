package com.department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.department.dto.DepartmentDto;
import com.department.model.Department;

@Mapper(implementationPackage = "mapper.impl")
public interface DepartmentMapper {

	DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

	DepartmentDto entityToDto(Department department);

	Department dtoToEntity(DepartmentDto departmentDto);

}
