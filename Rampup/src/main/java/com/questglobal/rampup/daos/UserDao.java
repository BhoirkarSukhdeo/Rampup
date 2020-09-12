package com.questglobal.rampup.daos;

import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.User;

public interface UserDao {

	User addUser(UserDto userDto) throws Exception;
}
