package com.hk.api.app.services;

import java.util.List;

import com.hk.api.app.models.Department;

public interface DepartmentService {
	Department saveDepartment(Department dept);

	List<Department> getAllDepartment();

	Department getDepartmentById(long id);
	
	void deleteDepartment(long id);
}
