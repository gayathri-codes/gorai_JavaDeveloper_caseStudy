package com.gorai.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorai.model.Employee;
import com.gorai.model.OtherDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OtherDetailsDTO {
	@JsonIgnore
	private Long id;
	private String department;
    private String manager;
}
