package com.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.dto.ApiResponseDTO;
import com.employeeservice.dto.EmployeeDTO;
import com.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/appi/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO dto){
		EmployeeDTO emp1 = service.saveemployee(dto);
		return new ResponseEntity<>(emp1, HttpStatus.CREATED);
	}
	@GetMapping("/code/{id}")
	public ResponseEntity<ApiResponseDTO> findbyid(@PathVariable Long id){
		ApiResponseDTO emp2 = service.getEmployeeById(id);
		return new ResponseEntity<>(emp2,HttpStatus.OK);
	}

}
