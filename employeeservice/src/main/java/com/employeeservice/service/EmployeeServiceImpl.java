package com.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeeservice.dto.ApiResponseDTO;
import com.employeeservice.dto.DepartmentDTO;
import com.employeeservice.dto.EmployeeDTO;
import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EmployeeDTO saveemployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDepartmentCode(employeeDTO.getDepartmentCode());
		Employee emp1 = repo.save(employee);
		return new EmployeeDTO
				(
					emp1.getFirstName(),emp1.getLastName(),emp1.getEmail(),emp1.getDepartmentCode()	
						);
	}

	@Override
	public ApiResponseDTO getEmployeeById(Long id) {
		Employee emp2 = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
		ResponseEntity<DepartmentDTO> reponsEntity = restTemplate.getForEntity
				("http://localhost:9090/appi/department/code/"+emp2.getDepartmentCode(), DepartmentDTO.class);
		EmployeeDTO emp3 = new EmployeeDTO(
				emp2.getFirstName(),emp2.getLastName(),emp2.getEmail(),emp2.getDepartmentCode()
				);
		DepartmentDTO dto = reponsEntity.getBody();
		ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
		apiResponseDTO.setEmployee1(emp3);
		apiResponseDTO.setDepartment1(dto);
		return apiResponseDTO;
	}

}
