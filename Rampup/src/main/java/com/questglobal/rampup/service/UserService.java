package com.questglobal.rampup.service;

import java.util.List;

import com.questglobal.rampup.dtos.UserDto;

public interface UserService {

	// add user details
	UserDto addUser(UserDto userDto) throws Exception;

	// get All Users
	List<UserDto> getAllUsers();

	// get user details by id
	UserDto getUser(Integer id) throws Exception;

	// update user by id
	UserDto updateUser(Integer id, UserDto dto) throws Exception;

	// remove user details by id
	boolean removeUser(Integer id);
}
