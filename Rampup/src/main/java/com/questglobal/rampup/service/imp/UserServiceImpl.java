package com.questglobal.rampup.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questglobal.rampup.controllers.UserController;
import com.questglobal.rampup.daos.UserDao;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.User;
import com.questglobal.rampup.security.Utility;
import com.questglobal.rampup.service.UserService;

/**
 * User  Service Implementation 
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserDto addUser(UserDto userDto) throws Exception {
		User user = null;
		try {
			user = userDao.addUser(userDto);
		} catch (Exception e) {
			log.error("UserServiceImpl: DB save error" + e.getMessage());
			throw e;
		}
		return Utility.getUserDtoFromUserEntity(user);
	}

}
