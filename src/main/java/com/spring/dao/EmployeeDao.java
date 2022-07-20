package com.spring.dao;

import java.util.List;

import com.spring.entities.Employee;

public interface EmployeeDao {
	
	public int insert(Employee employee);
	
	public Employee getEmployee(int id);
	
	public List<Employee>getEmployeeList();
	
	public int deleteSingleEmp(int id);
	
	public int updateEmp(Employee employee);
	
}
