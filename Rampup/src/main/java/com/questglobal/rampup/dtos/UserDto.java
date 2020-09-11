package com.questglobal.rampup.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private Integer id;
	private String name;
	private String address;
	private String userName;
	private String password;
}
