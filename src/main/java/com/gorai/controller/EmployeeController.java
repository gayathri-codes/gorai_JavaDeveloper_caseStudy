package com.gorai.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gorai.dto.EmployeeDTO;
import com.gorai.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/employment-agreements")
@Tag(name = "Employment Agreement Management Systems")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	@Operation(
	        operationId = "createEmployeeAgreement",
	        summary = "Post Employee Agreement",
	        description = "This method will create a new employee agreement"
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Successfully created the employee agreement"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	public ResponseEntity<EmployeeDTO> saveEmployeeAgreement(@RequestBody EmployeeDTO empDTO){		
		
		EmployeeDTO savedEmpDTO=empService.saveEmployeeAgreement(empDTO);
		return new ResponseEntity<>(savedEmpDTO,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	 @Operation(
		        operationId = "getEmployeeAgreement",
		        summary = "Get Employee Agreement",
		        description = "This method will fetch an employee agreement by ID"
		    )
		    @ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Successfully retrieved the employee agreement"),
		        @ApiResponse(responseCode = "404", description = "Employee agreement not found"),
		        @ApiResponse(responseCode = "500", description = "Internal server error")
		    })
	public ResponseEntity<EmployeeDTO> getEmployeeAgreement(@PathVariable Long id ){		
		
		EmployeeDTO savedEmpDTO=empService.getEmployeeAgreement(id);
		return new ResponseEntity<>(savedEmpDTO,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	@Operation(
	        operationId = "update EmployeeAgreement",
	        summary = "Put Employee Agreement",
	        description = "This method will update an existing employee agreement"
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Successfully updated the employee agreement"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	public ResponseEntity<EmployeeDTO> updateEmployeeAgreement(@RequestBody EmployeeDTO empDTO,@PathVariable Long id){		
		
		EmployeeDTO savedEmpDTO=empService.updateEmployeeAgreementById(id,empDTO);
		return new ResponseEntity<>(savedEmpDTO,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	@Operation(
	        operationId = "delete EmployeeAgreement",
	        summary = "Delete Employee Agreement",
	        description = "This method will delete an existing employee agreement"
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Successfully deleted the employee agreement"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	public ResponseEntity<String> deleteEmployeeAgreement(@PathVariable Long id){		
		
		empService.deleteEmployeeAgreementById(id);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		
	}
	
	@GetMapping()
	@Operation(
	        operationId = "getAll EmployeeAgreement",
	        summary = "get all Employee Agreement",
	        description = "This method will get list of employee agreement"
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Successfully retrieved all employee agreements"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeAgreements() {
		List<EmployeeDTO>  empList= this.empService.getAllEmployeeAgreements();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	
	@GetMapping("/search")
	@Operation(
	        operationId = "search filter for EmployeeAgreement",
	        summary = "search filter for Employee Agreement",
	        description = "This method will get list of employee agreement after filtering based on search"
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Successfully retrieved all employee agreements based on search"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	public ResponseEntity<List<EmployeeDTO>> searchEmployeeAgreement(@RequestParam("query") String query,@RequestParam(value = "minSalary", required = false) BigDecimal minSalary){
        return ResponseEntity.ok(empService.searchEmployeeAgreement(query,minSalary));
    }
	
//	public ResponseEntity<List<EmployeeDTO>> filterEmployeeAgreementBySearch(@RequestParam(required = false) String employeeName,
//            @RequestParam(required = false) String role,
//            @RequestParam(required = false) BigDecimal minSalary,
//            @RequestParam(required = false) BigDecimal maxSalary,
//            @RequestParam(required = false) String startDate,
//            @RequestParam(required = false) String endDate) {
//		List<EmployeeDTO>  empList= this.empService.filterEmployeeAgreementBySearch(employeeName,role,minSalary,maxSalary,startDate,endDate);
//		return new ResponseEntity<>(empList, HttpStatus.OK);
//	}
}
