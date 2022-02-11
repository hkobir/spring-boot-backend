package com.hk.api.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hk.api.app.exceptions.ResourceNotFoundException;
import com.hk.api.app.models.Employ;
import com.hk.api.app.repository.EmployRepository;
import com.hk.api.app.services.EmployService;



@Service
public class EmployeeServiceImpl implements EmployService{

	private EmployRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employ saveEmployee(Employ employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employ> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employ getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employ", "Id", id));
		
	}

	@Override
	public Employ updateEmployee(Employ employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employ existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employ", "Id", id)); 
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employ", "Id", id));
		employeeRepository.deleteById(id);
	}
	
}
