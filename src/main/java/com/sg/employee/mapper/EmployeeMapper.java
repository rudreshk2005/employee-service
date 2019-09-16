package com.sg.employee.mapper;

import com.sg.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet rs, int rownumber)throws SQLException{

        System.out.println("int row number ::: "+rownumber);

        Employee employee=new Employee();

        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("firstName"));
        employee.setLastName(rs.getString("lastName"));
        employee.setDob(rs.getString("dob"));
        employee.setGender(rs.getString("gender"));
        employee.setDepartment(rs.getString("department"));

        return employee;


    }

}
