package com.hk.api.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.api.app.models.Employ;
import com.hk.api.app.services.EmployService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployService employeeService;

	public EmployeeController(EmployService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Employ> saveEmployee(@RequestBody Employ employee) {
		return new ResponseEntity<Employ>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// build get all employees REST API
	@GetMapping
	public List<Employ> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employ> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employ>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employ> updateEmployee(@PathVariable("id") long id, @RequestBody Employ employee) {
		return new ResponseEntity<Employ>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		// delete employee from DB
		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

}
