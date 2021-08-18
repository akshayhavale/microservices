package com.user.service;

import org.springframework.http.ResponseEntity;

import com.user.dtos.PersistableUser;
import com.user.dtos.ReadableUser;

public interface UserService {

	ResponseEntity<ReadableUser> create(PersistableUser persistableUser);

	ResponseEntity<ReadableUser> getById(Long id);

	void deleteById(Long id);

}
