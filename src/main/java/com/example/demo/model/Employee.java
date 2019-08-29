package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="id")
	int id;
	@Column(name="emp_name")
	String name;
	@Column(name="salary")
	int salary;
	@Column(name="port")
	int port;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Employee()
	{
		
	}
	
	public Employee(int id, String name, int salary, int port) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.port = port;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
