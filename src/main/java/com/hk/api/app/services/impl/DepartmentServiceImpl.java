package com.hk.api.app.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hk.api.app.exceptions.ResourceNotFoundException;
import com.hk.api.app.models.Department;
import com.hk.api.app.repository.DepartmentRepo;
import com.hk.api.app.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepo departmentRepo;

	public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
		super();
		this.departmentRepo = departmentRepo;
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(long id) {

		return departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("department", "Id", id));

	}

	@Override
	public void deleteDepartment(long id) {

		// check whether a employee exist in a DB or not
		departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("department", "Id", id));
		departmentRepo.deleteById(id);
	}
}
