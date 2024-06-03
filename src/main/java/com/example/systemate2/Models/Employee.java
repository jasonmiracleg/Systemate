package com.example.systemate2.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Employee {
    // Attributes
    private String name, username, password, title;
    private Long salary = 0L;
    private ArrayList<Integer> employeeAttendance = new ArrayList<>();
    private Request request;
    private int currAttendance;


    // Getter-Setter
    public void setCurrAttendance(int attendance) {
        this.currAttendance = attendance;
    }
    public int getCurrAttendance() {
        return currAttendance;
    }
    public String getName()
    {
        return name;
    }
    public ArrayList<Integer> getEmployeeAttendance()
    {
        return employeeAttendance;
    }
    public void setAttendance(int attendanceSym)
    {
        employeeAttendance.add(attendanceSym);
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public Long getSalary()
    {
        return salary;
    }

    public void setSalary(Long salary){
        this.salary = salary;
    }

    public void raiseSalary(Long salary){
        this.salary += salary;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Request getRequest()
    {
        return request;
    }

    public void updateRequest(){
        request = null;
    }

    // Method
    public void requestTitle(String title)
    {
        if (request == null)
        {
            request = new Request(title);
        }
    }
    public void requestSalary(Long salary)
    {
        if (request == null)
        {
            request = new Request(salary);
        }
    }

    // Constructor
    public Employee(String name, String username, String password, String title)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.title = title;
    }

    public StringProperty getEmployeeName(){
        return new SimpleStringProperty(name);
    }

    public StringProperty getRequestProperty(){
        if (request != null){
            if (request.getTypeRequest().equalsIgnoreCase("title")){
                return new SimpleStringProperty(request.getRequestTitle());
            } else if (request.getTypeRequest().equalsIgnoreCase("salary")){
                return new SimpleStringProperty("Rp " +Long.toString(request.getRequestSalary()));
            }
        }
        return new SimpleStringProperty("");
    }
}
