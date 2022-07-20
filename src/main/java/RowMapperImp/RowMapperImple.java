package RowMapperImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.entities.Employee;

public class RowMapperImple implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setAddress(rs.getString(3));
		return employee;
	}

}
