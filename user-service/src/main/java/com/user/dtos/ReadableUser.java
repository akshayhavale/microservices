package com.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReadableUser {

	private Long id;
	private String name;
	private DepartmentDto department;

}
