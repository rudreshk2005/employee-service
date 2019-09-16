package com.sg.employee.service;

import com.sg.employee.data.EmployeeRepository;
import com.sg.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeData;


    @Override
    public int registerEmployee(Employee employee) {
       return employeeData.insert(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return  employeeData.findAll();
    }
}
