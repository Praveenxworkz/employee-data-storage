package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Employee;
import com.org.exception.ResourceNotFoundException;
import com.org.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployeeDetails(@Valid Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EmployeeDetails", "id", id));
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployeeDetails(Long id, @Valid Employee employee) throws ResourceNotFoundException {
		Employee existingEmployee = getEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setDepartment(employee.getDepartment());
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployeeDetails(Long id) throws ResourceNotFoundException {
		Employee employeeDetails = getEmployeeById(id);
		employeeRepository.delete(employeeDetails);
	}


}
