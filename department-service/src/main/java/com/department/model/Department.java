package com.department.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private Long id;

	@Column(name = "DEPARTMENT_NAME", unique = true, nullable = false)
	private String departmentName;

	@Column(name = "DEPARTMENT_CODE", unique = true, nullable = false)
	private String departmentCode;

}
