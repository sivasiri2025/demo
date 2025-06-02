package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.EmployeeDetails;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dao.StudentRepository;

import jakarta.validation.constraints.NotNull;

@RestController
@Validated
public class DemoController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from Springboot";
	}
	
	@GetMapping("/delete-student-table")
	public String deleteTable() {
		int result = studentRepository.deleteTableIfExists();
		return "Table Delete result: "+ result;
	}
	
	@DeleteMapping("/delete-student/{tablename}")
	public String deleteTablePath(@PathVariable(value = "tablename") @NotNull String tablename) {
		int result = studentRepository.deleteTable(tablename);
		return "Table Delete result: "+ result;
	}
	
	@GetMapping("/employees")
	public List<EmployeeDetails> getEmployees(){
		return employeeRepository.findAll();
	}
	
}
