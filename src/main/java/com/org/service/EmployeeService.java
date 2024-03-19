package com.org.service;

import java.util.List;

import com.org.entity.Employee;
import com.org.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

	public interface EmployeeService {
	    Employee createEmployeeDetails(@Valid Employee employeeDetails);
	    Employee getEmployeeById(Long id) throws ResourceNotFoundException;
	    List<Employee> getAllEmployeeDetails();
	    Employee updateEmployeeDetails(Long id, @Valid Employee employeeDetails) throws ResourceNotFoundException;
	    void deleteEmployeeDetails(Long id) throws ResourceNotFoundException;
	

	
}
