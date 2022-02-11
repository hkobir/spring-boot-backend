package com.hk.api.app.services;

import java.util.List;

import com.hk.api.app.models.Employ;

public interface EmployService {
	Employ saveEmployee(Employ employee);
	List<Employ> getAllEmployees();
	Employ getEmployeeById(long id);
	Employ updateEmployee(Employ employee, long id);
	void deleteEmployee(long id);
}
