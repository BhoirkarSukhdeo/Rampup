package com.questglobal.rampup.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="expense")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "expense_title")
	private String expenseTitle;

	@Column(name = "category")
	private String category;

	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private float amount;

	@Column(name = "date")
	private Date date;
}
