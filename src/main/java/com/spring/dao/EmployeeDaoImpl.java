package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entities.Employee;

import RowMapperImp.RowMapperImple;

public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	JdbcTemplate template;
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		try {
		String query="insert into employee value(?,?,?)";
		return this.template.update(query,employee.getId(),employee.getName(),employee.getAddress());
		}catch(DuplicateKeyException k)
		{
			System.out.print("duplicate key");
		}
		return 0;
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		
		String query="select *from employee where id=?";
		RowMapper<Employee> row=new RowMapperImple();
		Employee employee=this.template.queryForObject(query,row,id);
		return employee;
	}

	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		String query="select *from employee";
		RowMapper<Employee> row=new RowMapperImple();
		List<Employee>employee=this.template.query(query,row);
		return employee;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int deleteSingleEmp(int id) {
		// TODO Auto-generated method stub
		String query="delete from employee where id=?";
		return this.template.update(query,id);
	}

	public int updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		String query ="update table emplyee set name=? and address=?";
		return this.template.update(query,employee.getName(),employee.getAddress());
	}
}
