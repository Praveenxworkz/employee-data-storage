package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Employee;
import com.org.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/employee-details")
@Validated
public class EmployeeController {

	private final EmployeeService employeeDetailsService;

	@Autowired
	public EmployeeController(EmployeeService employeeDetailsService) {
		this.employeeDetailsService = employeeDetailsService;
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployeeDetails(@Valid @RequestBody Employee employeeDetails) {
		Employee createdEmployeeDetails = employeeDetailsService.createEmployeeDetails(employeeDetails);
		return new ResponseEntity<>(createdEmployeeDetails, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable @NotNull Long id) {
		Employee employeeDetails = employeeDetailsService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDetails);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
		List<Employee> allEmployeeDetails = employeeDetailsService.getAllEmployeeDetails();
		return ResponseEntity.ok(allEmployeeDetails);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable @NotNull Long id,
			@Valid @RequestBody Employee employeeDetails) {
		Employee updatedEmployeeDetails = employeeDetailsService.updateEmployeeDetails(id, employeeDetails);
		return ResponseEntity.ok(updatedEmployeeDetails);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable @NotNull Long id) {
		employeeDetailsService.deleteEmployeeDetails(id);
		return ResponseEntity.noContent().build();
	}

	// You can add additional endpoints and error handling if needed

}
