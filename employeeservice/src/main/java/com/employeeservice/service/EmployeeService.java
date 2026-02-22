package com.employeeservice.service;

import com.employeeservice.dto.ApiResponseDTO;
import com.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO saveemployee(EmployeeDTO employeeDTO);
	public ApiResponseDTO getEmployeeById(Long id);

}
