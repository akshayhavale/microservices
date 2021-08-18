package com.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersistableUser {

	private Long id;
	private String name;
	private String departmentName;

}
