package com.hk.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.api.app.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
