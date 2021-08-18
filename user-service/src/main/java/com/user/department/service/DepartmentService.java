package com.user.department.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.dtos.DepartmentDto;

@Service
@FeignClient(name = "${department.service.url}")
public interface DepartmentService {

	@GetMapping("/name/{name}")
	ResponseEntity<DepartmentDto> getDepartmentByName(@PathVariable(value = "name") String name);

}
