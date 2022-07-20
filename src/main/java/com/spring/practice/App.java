package com.spring.practice;

import org.springframework.context.ApplicationContext;
import java.util.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.EmployeeDaoImpl;
import com.spring.entities.Employee;


public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
    	EmployeeDaoImpl emp=context.getBean("dao",EmployeeDaoImpl.class);
    	boolean flag=true;
        while(flag)
        {
        	System.out.println("1. Insert into the database");
        	System.out.println("2. select single data from database");
        	System.out.println("3. select all data from database");
        	System.out.println("4. update single data by taking user id");
        	System.out.println("5. delete single data from data base");
        	System.out.println("Please select one of the follow above");
        	
        	int x;
        	Scanner sc=new Scanner(System.in);
        	x=sc.nextInt();
        	switch(x)
        	{
        	case 1:
        		System.out.println("Enter employee id");
        		int id=sc.nextInt();
        		System.out.println("Enter employee name");
        		String name=sc.next();
        		System.out.println("Enter employee address");
        		String address=sc.next();
        		Employee newEmp=new Employee(id,name,address);
        		int result=emp.insert(newEmp);
        		if(result==1)
        		{
        			System.out.println("\nData inserted sucessfully.\n");
        		}
        		else {
        			System.out.println("\nDuplicated data is inserted\n");
        		}
        		break;
        	case 2:
        		System.out.println("Enter id to view it's data");
        		int id1=sc.nextInt();
        		Employee employee=emp.getEmployee(id1);
        		System.out.println("\n"+employee+"\n");
        		break;
        	case 3:
        		System.out.println("Get all data");
        		List<Employee> listEmp=emp.getEmployeeList();
        		for(int i=0;i<listEmp.size();++i)
        		{
        			System.out.println(listEmp.get(i));
        		}
        		System.out.println();
        		break;
        	case 4:
        		System.out.println("Enter id you want to update");
        		id1=sc.nextInt();
        		System.out.println("Enter your name");
        		name=sc.next();
        		System.out.println("Enter your address");
        		address=sc.next();
        		employee=new Employee(id1,name,address);
        		emp.updateEmp(employee);
        		break;
        	case 5:
        		System.out.println("Enter the id you want to delete");
        		id1=sc.nextInt();
        		emp.deleteSingleEmp(id1);
        		if(id1==1)
        		{
        			System.out.println("Successfully deleted");
        		}
        		else {
        			System.out.println("No such data");
        		}
        		break;
        	case 6:
        		flag=false;
        		break;
        		
        	}
        	System.out.println("*******************************************\n**************************************");
        	
        	
        	
        }
    }
}
