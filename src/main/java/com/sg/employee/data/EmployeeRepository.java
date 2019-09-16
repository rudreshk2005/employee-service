package com.sg.employee.data;


import com.sg.employee.mapper.EmployeeMapper;
import com.sg.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Employee employee){

        return jdbcTemplate.update("insert into employee(id,firstName,lastname,dob,gender,department) " + "values(?,?,?,?,?,?)",
                new Object[]{employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getDob(),employee.getGender(),employee.getDepartment()});
    }

    public List<Employee> findAll(){


        return jdbcTemplate.query("select * from employee order by firstName asc ",new EmployeeMapper());
    }
}
