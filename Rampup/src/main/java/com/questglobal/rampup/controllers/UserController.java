package com.questglobal.rampup.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping(ApiConstants.GET_ALL_USERS)
	public ResponseEntity<?> getAllUsers() {
		ResponseEntity<?> response = null;
		List<UserDto> users = null;
		try {
			users = userService.getAllUsers();
			response = new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserController : Error getting Users" + e.getMessage());
			response = new ResponseEntity<String>("{ \"msg\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping(ApiConstants.GET_USER)
	public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
		ResponseEntity<?> response = null;
		UserDto user = null;
		try {
			user = userService.getUser(id);
			response = new ResponseEntity<UserDto>(user, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserController : Error getting User" + e.getMessage());
			response = new ResponseEntity<String>("{ \"msg\":\"" + e.getMessage() + "\" }", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping(ApiConstants.GET_USER)
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody UserDto dto) {
		ResponseEntity<?> response = null;
		UserDto user = null;
		try {
			user = userService.updateUser(id, dto);
			response = new ResponseEntity<UserDto>(user, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserController : Error getting while update User" + e.getMessage());
			response = new ResponseEntity<String>("{ \"msg\":\"" + e.getMessage() + "\" }", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping(ApiConstants.GET_USER)
	public ResponseEntity<?> removeUser(@PathVariable("id") Integer id){
		ResponseEntity<?> response = null;
        boolean changes = false;
        try {
            changes = userService.removeUser(id);
        } catch (Exception e) {
            log.error("Erorr deleting user " + id);
        }
        if (changes)
            response = new ResponseEntity<String>("{\"msg\": \"User deleted successfully\"}", HttpStatus.OK);
        else
            response = new ResponseEntity<String>("{\"msg\": \"Erorr deleting user\"} ", HttpStatus.BAD_REQUEST);
        return response;
	}
}
