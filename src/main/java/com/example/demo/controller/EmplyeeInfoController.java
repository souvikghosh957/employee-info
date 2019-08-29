package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeInfoService;

@RestController
public class EmplyeeInfoController {
	
	@Autowired
	EmployeeInfoService employeeInfoService;
	
	@Autowired
	Environment environment;

	
	@GetMapping("/rest/get-name/{id}")
	public Optional<Employee> getName(@PathVariable("id") int id)
	{
		Optional<Employee> emp = employeeInfoService.getName(id);
		emp.get().setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return emp;
	}
	
	@GetMapping("/rest/get-all")
	public List<Employee> getAllName()
	{
		List<Employee> empList=employeeInfoService.getAll();
		empList.forEach(n->n.setPort(Integer.parseInt(environment.getProperty("local.server.port"))));
		
		return empList;
	}
	
	@PostMapping("/rest/save-name")
	public void saveName(@RequestBody Employee emp)
	{
		employeeInfoService.saveName(emp);
	}
	
	@DeleteMapping("/rest/delete-name/{id}")
	public void deleteName(@PathVariable("id") int id)
	{
		employeeInfoService.deleteName(id);
	}
	
}
