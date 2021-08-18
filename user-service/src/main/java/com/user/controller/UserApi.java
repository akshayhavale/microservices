package com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dtos.PersistableUser;
import com.user.dtos.ReadableUser;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

	private static final String MESSAGE = "ENTERED USER API";

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<ReadableUser> create(@RequestBody PersistableUser persistableUser) {
		LOGGER.info(MESSAGE);
		return userService.create(persistableUser);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ReadableUser> getById(@PathVariable(value = "id") Long id) {
		LOGGER.info(MESSAGE);
		return userService.getById(id);
	}

	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable(value = "id") Long id) {
		LOGGER.info(MESSAGE);
		userService.deleteById(id);
	}

}
