package com.sg.employee.service;

import com.sg.employee.model.Employee;

import java.util.List;


public interface EmployeeService {

    int registerEmployee(Employee employee);
    List<Employee> getAllEmployee();
}
