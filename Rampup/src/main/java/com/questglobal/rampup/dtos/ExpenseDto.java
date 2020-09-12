package com.questglobal.rampup.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ExpenseDto class
 * 
 * @author Sukhdeo Bhoirkar
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

	private Integer id;
	private String expenseTitle;
	private String category;
	private String description;
	private float amount;
	private Date date;
	private Integer user;
}
