package com.questglobal.rampup.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questglobal.rampup.constants.ApiConstants;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.service.UserService;

/**
 * Controller class for User Operations
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@RestController
@RequestMapping(ApiConstants.BASE_URL)
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(ApiConstants.ADD_USER)
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		ResponseEntity<?> response = null;
		UserDto userResponse = null;
		try {
			userResponse = userService.addUser(userDto);
			response = new ResponseEntity<UserDto>(userResponse, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserController : User registration fail" + e.getMessage());
			response = new ResponseEntity<String>("{ \"msg\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
