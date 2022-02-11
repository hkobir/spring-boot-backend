package com.hk.api.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.api.app.models.Department;
import com.hk.api.app.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	// build create dept REST API
	@PostMapping()
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
	}

	// build get all dept REST API
	@GetMapping
	public List<Department> getAllEmployees() {
		return departmentService.getAllDepartment();
	}

	// build get dept by id REST API
	// http://localhost:8080/api/departments/1
	@GetMapping("{id}")
	public ResponseEntity<Department> getEmployeeById(@PathVariable("id") long deptId) {
		return new ResponseEntity<Department>(departmentService.getDepartmentById(deptId), HttpStatus.OK);
	}

	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id) {

		// delete employee from DB
		departmentService.deleteDepartment(id);

		return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);
	}

}
