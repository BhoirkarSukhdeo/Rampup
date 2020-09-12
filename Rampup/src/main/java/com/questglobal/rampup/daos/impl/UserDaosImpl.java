package com.questglobal.rampup.daos.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questglobal.rampup.controllers.UserController;
import com.questglobal.rampup.daos.UserDao;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.User;
import com.questglobal.rampup.repository.UserRepository;
import com.questglobal.rampup.security.Utility;

/**
 * User Dao Implementation 
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@Repository
public class UserDaosImpl implements UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(UserDto userDto) throws Exception {
		User user = null;
		try {
			user = Utility.getUserEntityFromUserDto(userDto);
			userRepository.save(user);
		} catch (Exception e) {
			log.error("UserDaoImpl : DB save error" + e.getMessage());
			throw e;
		}
		return user;
	}

}
