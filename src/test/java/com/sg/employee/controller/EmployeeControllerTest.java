package com.sg.employee.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.employee.employeeservice.EmployeeServiceApplication;
import com.sg.employee.model.Employee;
import com.sg.employee.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmployeeServiceApplication.class})
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    Employee employee=new Employee(5, "testFirstName","testLastName","09-12-1982","Male","GTI");
    String employeeString=asJsonString(employee);

    Employee [] employeeList=new Employee[2];


    @Test
    public void registerEmployee() throws Exception{

        Mockito.when(
                employeeService.registerEmployee(
                        Mockito.any(Employee.class))).thenReturn(0);

        RequestBuilder requestBuilder=MockMvcRequestBuilders
                                        .post("/api/v1/employee")
                                        .accept(MediaType.APPLICATION_JSON).content(employeeString)
                                        .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response=result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());


    }


    @Test
    public void getAllEmployee() throws Exception{

        List<Employee> employeeList= Arrays.asList(employee);

        given(employeeService.getAllEmployee()).willReturn(employeeList);

        ResultActions resultActions = this.mockMvc.perform(get("/api/v1/employee")).andExpect(status().isOk());

    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
