package com.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.user.dtos.DepartmentDto;
import com.user.dtos.PersistableUser;
import com.user.dtos.ReadableUser;
import com.user.model.User;

@Mapper(implementationPackage = "mapper.impl")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User perisistableUserToUser(PersistableUser user);

	@Mapping(target = "id", source = "user.id")
	@Mapping(target = "name", source = "user.name")
	@Mapping(target = "department", source = "department")
	ReadableUser convertToReadableUser(User user, DepartmentDto department);

}
