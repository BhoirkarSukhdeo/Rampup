package com.questglobal.rampup.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questglobal.rampup.daos.UserDao;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.User;
import com.questglobal.rampup.security.Utility;
import com.questglobal.rampup.service.UserService;

/**
 * User Service Implementation
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> dto = null;
		List<User> users = null;
		try {
			users = userDao.getAllUsers();
			dto = users.stream().map(x -> Utility.getUserDtoFromUserEntity(x)).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Error getting while get all users");
		}
		return dto;
	}

	@Override
	public UserDto getUser(Integer id) throws Exception {
		UserDto dto = null;
		User user = null;
		try {
			user = userDao.getUser(id);
			if (user == null)
				throw new Exception("User not found");
			dto = Utility.getUserDtoFromUserEntity(user);
		} catch (Exception e) {
			log.error("Error getting while get user details");
			throw new Exception("User not found");
		}
		return dto;
	}

	@Override
	public UserDto updateUser(Integer id, UserDto dto) throws Exception {
		UserDto userDto = null;
		User user = null;
		try {
			user = userDao.getUser(id);
			if (user != null) {
				if (dto.getId() != null)
					user.setId(user.getId());
				if (dto.getName() != null)
					user.setName(dto.getName());
				if (dto.getAddress() != null)
					user.setAddress(dto.getAddress());
				if (dto.getUserName() != null)
					user.setUserName(dto.getUserName());
				if (dto.getPassword() != null)
					user.setPassword(dto.getPassword());
				user = userDao.updateUser(user);
				userDto = Utility.getUserDtoFromUserEntity(user);
			} else {
				log.error("error getting while update user details");
				throw new Exception("User not found in DB");
			}
		} catch (Exception e) {
			log.error("User Not found");
			throw new Exception("User not found");
		}
		return userDto;
	}

	@Override
	public boolean removeUser(Integer id) {
		boolean result = false;
		try {
			result = userDao.deleteUser(id);
		} catch (Exception e) {
			log.error("Error while removing user: " + id);
		}
		return result;
	}

}
