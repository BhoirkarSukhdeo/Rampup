package com.questglobal.rampup.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.questglobal.rampup.dtos.ExpenseDto;
import com.questglobal.rampup.dtos.UserDto;
import com.questglobal.rampup.model.Expense;
import com.questglobal.rampup.model.User;

/**
 * Utility class
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
public class Utility {

	private static final Logger log = LoggerFactory.getLogger(Utility.class);

	public static User getUserEntityFromUserDto(UserDto dto) {
		User user = null;
		try {
			user = new User();
			user.setId(dto.getId());
			user.setName(dto.getName());
			user.setAddress(dto.getAddress());
			user.setUserName(dto.getUserName());
			user.setPassword(dto.getPassword());
		} catch (Exception e) {
			user = null;
			log.error("User parsing error");
		}
		return user;
	}

	public static UserDto getUserDtoFromUserEntity(User user) {
		UserDto dto = null;
		try {
			dto = new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setAddress(user.getAddress());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
		} catch (Exception e) {
			dto = null;
			log.error("UserDto parsing error");
		}
		return dto;
	}

	public static Expense getExpenseEntityFromExpenseDto(ExpenseDto dto) {
		Expense expense = null;
		try {
			expense = new Expense();
			expense.setId(dto.getId());
			expense.setExpenseTitle(dto.getExpenseTitle());
			expense.setDescription(dto.getDescription());
			expense.setCategory(dto.getCategory());
			expense.setAmount(dto.getAmount());
			expense.setDate(dto.getDate());
		} catch (Exception e) {
			expense = null;
			log.error("Expense parsing error");
		}
		return expense;
	}

	public static ExpenseDto getExpenseDtoFromExppense(Expense expense) {
		ExpenseDto dto = null;
		try {
			dto = new ExpenseDto();
			dto.setId(expense.getId());
			dto.setExpenseTitle(expense.getExpenseTitle());
			dto.setDescription(expense.getDescription());
			dto.setCategory(expense.getCategory());
			dto.setAmount(expense.getAmount());
			dto.setDate(expense.getDate());
		} catch (Exception e) {
			dto = null;
			log.error("ExpenseDto parsing error");
		}
		return dto;
	}
}
