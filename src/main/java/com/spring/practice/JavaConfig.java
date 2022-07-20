package com.spring.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.EmployeeDaoImpl;

import java.util.*;

import javax.sql.DataSource;

@Configuration
public class JavaConfig {
	@Bean
	public DataSource getSource()
	{
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		data.setUsername("root");
		data.setPassword("10573712");
		return data;
	}
	
	@Bean
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template=new JdbcTemplate(getSource());
		return template;
	}
	
	@Bean(name="dao")
	public EmployeeDaoImpl getDao()
	{
		EmployeeDaoImpl emp=new EmployeeDaoImpl();
		return emp;
	}
	
}
