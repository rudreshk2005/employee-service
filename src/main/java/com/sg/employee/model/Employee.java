package com.sg.employee.model;

public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String department;

    public Employee(){

    }

    public Employee(long id, String firstName, String lastName, String gender, String dob, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDob() {

        return dob;
    }

    public String getDepartment() {
        return department;
    }
}
