package com.sg.employee.mapper;

import com.sg.employee.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Employee mapRow(ResultSet rs, int rownumber)throws SQLException{

        LOGGER.info("EmployeeMapper :: int row number ::: "+rownumber);

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
