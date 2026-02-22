package com.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departmentservice.Entity.Department;
import com.departmentservice.dto.DepartmentDTO;

import java.util.List;


public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}
