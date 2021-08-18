package com.user.service;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.department.service.DepartmentService;
import com.user.dtos.DepartmentDto;
import com.user.dtos.PersistableUser;
import com.user.dtos.ReadableUser;
import com.user.mapper.UserMapper;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartmentService departmentService;

	@Override
	public ResponseEntity<ReadableUser> create(PersistableUser persistableUser) {
		LOGGER.info("ENTERED USER SERVICE CREATE METHOD");
		/**
		 * Check Department Exist by department Name;
		 */
		DepartmentDto departmentDto = null;
		try {
			departmentDto = departmentService.getDepartmentByName(persistableUser.getDepartmentName()).getBody();
		} catch (Exception e) {
			LOGGER.error("No Department found for Department Name : {}", persistableUser.getDepartmentName());
		}
		if (departmentDto == null) {
			LOGGER.debug("Error due to no Department exist for department name : {}",
					persistableUser.getDepartmentName());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User userEntity = UserMapper.INSTANCE.perisistableUserToUser(persistableUser);
		User savedEntity = userRepository.save(userEntity);

		ReadableUser readableUser = UserMapper.INSTANCE.convertToReadableUser(savedEntity, departmentDto);
		return new ResponseEntity<>(readableUser, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ReadableUser> getById(Long id) {
		LOGGER.info("ENTERED USER SERVICE GET BY ID METHOD");
		User user = userRepository.getById(id);
		if (user == null) {
			LOGGER.debug("Error due to no user exist for user id : {}", id);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		DepartmentDto departmentDto = departmentService.getDepartmentByName(user.getDepartmentName()).getBody();
		ReadableUser readableUser = UserMapper.INSTANCE.convertToReadableUser(user, departmentDto);
		return new ResponseEntity<>(readableUser, HttpStatus.OK);
	}

	@Override
	public void deleteById(Long id) {
		LOGGER.info("ENTERED USER SERVICE DELETE BY ID METHOD");
		User user = userRepository.getById(id);
		if (user == null) {
			LOGGER.debug("Error due to no user exist for user id : {}", id);
			throw new ServiceException("USER Does n't exist");
		}
		userRepository.delete(user);

	}

}
