package com.gorai.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gorai.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{

	
	@Query("SELECT e FROM Employee e WHERE " +
            "e.employeeName LIKE CONCAT('%',:query, '%') OR" +
            " e.role LIKE CONCAT('%', :query, '%') OR"+
            " e.startDate LIKE CONCAT('%',:query, '%') OR" +
            " e.endDate LIKE CONCAT('%', :query, '%') OR"+
            " e.salary >=:minSalary OR" +
            " e.terms LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployeeAgreement(@Param("query")String query,@Param("minSalary")BigDecimal minSalary);
	
}
