package com.questglobal.rampup.service;

import com.questglobal.rampup.dtos.UserDto;

public interface UserService {

	// add user details
	UserDto addUser(UserDto userDto) throws Exception;
}
