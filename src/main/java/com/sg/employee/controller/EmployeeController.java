package com.sg.employee.controller;

import com.sg.employee.model.Employee;
import java.util.List;

import com.sg.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping(value = "/api")
public class EmployeeController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeService employeeService;

    @PostMapping (value = "/v1/employee" , consumes ="application/json; charset=UTF-8")
    public void registerEmployee(Employee employee){
        LOGGER.info("EmployeeController : regiterEmployee method start");
        employeeService.registerEmployee(employee);
        LOGGER.info("EmployeeController : regiterEmployee method start");

    }

    @GetMapping(path = "/v1/employee" , produces ="application/json; charset=UTF-8")
    public List<Employee> getAllEmployee(){
        LOGGER.info("EmployeeController : getAllEmployee method start");
        return  employeeService.getAllEmployee();
    }

}
