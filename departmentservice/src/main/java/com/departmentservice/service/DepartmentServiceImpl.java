package com.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departmentservice.Entity.Department;
import com.departmentservice.dto.DepartmentDTO;
import com.departmentservice.repository.DepartmentRepo;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepo departmentrepo;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentdto) {
		Department department = new Department();
		department.setDepartmentName(departmentdto.getDepartmentName());
		department.setCompany(departmentdto.getCompany());
		department.setDepartmentDescription(departmentdto.getDepartmentDescription());
		department.setDepartmentCode(departmentdto.getDepartmentCode());
		Department d1 = departmentrepo.save(department);
		return new DepartmentDTO(
				d1.getDepartmentName(),d1.getCompany(),
				d1.getDepartmentDescription(),d1.getDepartmentCode()
				);
	}

	@Override
	public DepartmentDTO findbyDepartmentCode(String departmentCode) {
		Department d2 = departmentrepo.findByDepartmentCode(departmentCode);
		return new DepartmentDTO(
				d2.getDepartmentName(), d2.getCompany(),
				d2.getDepartmentDescription(),d2.getDepartmentCode()
				);
	}
}
