package com.questglobal.rampup.daos;

import java.util.List;

import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.User;

public interface UserDao {

	User addUser(UserDto userDto) throws Exception;

	List<User> getAllUsers();

	User getUser(Integer id);
	
	User updateUser(User user);
	
    boolean deleteUser(Integer id);
}
