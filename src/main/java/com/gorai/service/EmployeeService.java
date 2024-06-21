package com.gorai.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gorai.dto.EmployeeDTO;

@Service
public interface EmployeeService {
	public EmployeeDTO saveEmployeeAgreement(EmployeeDTO empDTO);

	public EmployeeDTO getEmployeeAgreement(Long id);

	public EmployeeDTO updateEmployeeAgreementById(Long id, EmployeeDTO empDTO);

	public void deleteEmployeeAgreementById(Long id);

public List<EmployeeDTO> getAllEmployeeAgreements();

	List<EmployeeDTO> filterEmployeeAgreementBySearch(String employeeName, String role, BigDecimal minSalary, BigDecimal maxSalary,
			String startDate, String endDate);

	public List<EmployeeDTO> searchEmployeeAgreement(String query,BigDecimal minSalary);
}
