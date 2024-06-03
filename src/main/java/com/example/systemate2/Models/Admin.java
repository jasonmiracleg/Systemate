package com.example.systemate2.Models;

import java.util.*;

/**
 * User Admin
 * 1. Manage Salary System
 * 2. Register Employees
 * 3. Employees' Bonus Approval
 * 4. Cash Flow
 */
public class Admin {

    // Attribute
    private String username, password;
    private Boolean approve;
    private ArrayList<Employee> employees = new ArrayList();
    private HashMap<String, Long> salaryList = new HashMap<>();

    // Getter-Setter
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }

    // Method

    public void addEmployee(Employee newEmployee){
        employees.add(newEmployee);
    }

    public HashMap<String, Long> getSalaryList(){
        return salaryList;
    }

    public void updateSalary(String title, Long salary){
        salaryList.put(title, salary);
    }
    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
