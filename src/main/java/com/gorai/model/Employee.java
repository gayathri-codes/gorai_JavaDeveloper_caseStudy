package com.gorai.model;

import java.math.BigDecimal;

//import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class Employee {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	private String employeeName;
	private String role;
	private String startDate;
	private String endDate;
	private BigDecimal salary;
	private String terms;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_details_id", referencedColumnName = "id")
	private OtherDetails otherDetails;

}
