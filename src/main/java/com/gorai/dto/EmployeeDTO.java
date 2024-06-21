package com.gorai.dto;

import java.math.BigDecimal;

import com.gorai.model.Employee;
import com.gorai.model.OtherDetails;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeeDTO {
	private Long id;
	 
	private String employeeName;
	private String role;
	private String startDate;
	private String endDate;
	private BigDecimal salary;
	private String terms;
	private OtherDetails otherDetails;
}
