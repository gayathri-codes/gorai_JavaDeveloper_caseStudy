package com.gorai.service;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorai.dto.EmployeeDTO;
import com.gorai.model.Employee;
import com.gorai.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDTO saveEmployeeAgreement(EmployeeDTO empDTO) {
		// TODO Auto-generated method stub
		Employee emp=modelMapper.map(empDTO, Employee.class);
		Employee savedEmployee = empRepo.save(emp);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO getEmployeeAgreement(Long id) {
		// TODO Auto-generated method stub
		Employee emp=empRepo.getById(id);
		EmployeeDTO empDTO=modelMapper.map(emp,EmployeeDTO.class);
		return empDTO;
	}

	@Override
	public EmployeeDTO updateEmployeeAgreementById(Long id, EmployeeDTO empDTO) {
		// TODO Auto-generated method stub
		Employee existingEmployee = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee agreement not found"));
        modelMapper.map(empDTO, existingEmployee);        
        Employee updatedEmployee = empRepo.save(existingEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
	}

	@Override
	public void deleteEmployeeAgreementById(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeAgreements() {
		// TODO Auto-generated method stub
		List<Employee> empList= empRepo.findAll();
		
		return empList.stream().map(emp -> mapToEmpDTOs(emp)).toList();
	}
	
	public EmployeeDTO mapToEmpDTOs(Employee emp) {
		return modelMapper.map(emp, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> filterEmployeeAgreementBySearch(String employeeName, String role, BigDecimal minSalary,
			BigDecimal maxSalary, String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<Employee> empList= empRepo.findAll();
		
		return empList.stream().
				filter(emp->emp.getEmployeeName().equalsIgnoreCase(employeeName)).
				filter(emp->emp.getRole().equalsIgnoreCase(role)).
				filter(emp->(minSalary == null || emp.getSalary().compareTo(minSalary) >= 0)).
				filter(emp->(maxSalary == null || emp.getSalary().compareTo(maxSalary) <= 0)). 
				filter(emp->emp.getStartDate().compareTo(startDate) >= 0). 
				filter(emp->emp.getEndDate().compareTo(endDate) <= 0).
				map(emp -> mapToEmpDTOs(emp)).toList();
	}

	@Override
	public List<EmployeeDTO> searchEmployeeAgreement(String query,BigDecimal minSalary) {
		// TODO Auto-generated method stub
		List<Employee> empList= empRepo.searchEmployeeAgreement(query,minSalary);	
		return empList.stream().map(emp -> mapToEmpDTOs(emp)).toList();
	}

}
