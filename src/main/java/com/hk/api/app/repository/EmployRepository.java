package com.hk.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hk.api.app.models.Employ;

public interface EmployRepository extends JpaRepository<Employ, Long>{

}
