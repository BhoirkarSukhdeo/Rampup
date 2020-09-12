package com.questglobal.rampup.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDto class
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private Integer id;
	private String name;
	private String address;
	private String userName;
	@JsonIgnore
	private String password;
}
