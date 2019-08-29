package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeInfoService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public void saveName(Employee emp)
	{
				
		employeeRepository.save(emp);
		
		
	}

	public Optional<Employee> getName(int id) throws RuntimeException {
		
		Optional<Employee> emp = employeeRepository.findById(id);
		if(!emp.isPresent())
		{
			throw new RuntimeException("No value found for the given id");
		}
		return employeeRepository.findById(id);
		
	}

	public void deleteName(int id) {

		employeeRepository.deleteById(id);
		
	}

	public List<Employee> getAll() {
	
		return employeeRepository.findAll();
	
	}

	
	
	
}
