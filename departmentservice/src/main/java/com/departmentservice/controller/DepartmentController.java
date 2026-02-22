package com.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.Entity.Department;
import com.departmentservice.dto.DepartmentDTO;
import com.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/appi/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public ResponseEntity<DepartmentDTO> saveddepartment(@RequestBody DepartmentDTO departmentdto){
		DepartmentDTO d1 = departmentService.saveDepartment(departmentdto);
		return new ResponseEntity<>(d1,HttpStatus.CREATED);
	}
	@GetMapping("/code/{code}")
	public ResponseEntity<DepartmentDTO> findbyDepartmentCode(@PathVariable("code") String code){
		DepartmentDTO d2 = departmentService.findbyDepartmentCode(code);
		return new ResponseEntity<>(d2,HttpStatus.OK);
	}

}
