package com.questglobal.rampup.security;

import com.questglobal.rampup.dtos.ExpenseDto;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.Expense;
import com.questglobal.rampup.model.User;

public class Utility {

	public static User getUserEntityFromUserDto(UserDto dto) throws Exception {
		User user = null;
		try {
			user = new User();
			user.setId(dto.getId());
			user.setName(dto.getName());
			user.setAddress(dto.getAddress());
			user.setUserName(dto.getPassword());
			user.setPassword(dto.getPassword());
		} catch (Exception e) {
			throw new Exception("User Parsing Error");
		}
		return user;
	}

	public static UserDto getUserDtoFromUserEntity(User user) throws Exception {
		UserDto dto = null;
		try {
			dto = new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setAddress(user.getAddress());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
		} catch (Exception e) {
			throw new Exception("UserDto Parsing Error");
		}
		return dto;
	}
	public static Expense getExpenseEntityFromExpenseDto(ExpenseDto dto) throws Exception {
		Expense expense=null;
		try {
			expense=new Expense();
			expense.setId(dto.getId());
			expense.setExpenseTitle(dto.getExpenseTitle());
			expense.setDescription(dto.getDescription());
			expense.setCategory(dto.getCategory());
			expense.setAmount(dto.getAmount());
			expense.setDate(dto.getDate());
		} catch (Exception e) {
			throw new Exception("Expense Parsing Error");
		}
		return expense;
	}
	
	public static ExpenseDto getExpenseDtoFromExppense(Expense expense) throws Exception {
		ExpenseDto dto=null;
		try {
			dto=new ExpenseDto();
			dto.setId(expense.getId());
			dto.setExpenseTitle(expense.getExpenseTitle());
			dto.setDescription(expense.getDescription());
			dto.setCategory(expense.getCategory());
			dto.setAmount(expense.getAmount());
			dto.setDate(expense.getDate());
		} catch (Exception e) {
			throw new Exception("ExpenseDto Parsing Error");
		}
		return dto;	
	}
}
