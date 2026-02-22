package com.departmentservice.service;

//import com.departmentservice.Entity.Department;
import com.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
	
	public DepartmentDTO saveDepartment(DepartmentDTO departmentdto);
	public DepartmentDTO findbyDepartmentCode(String departmentCode);

}
