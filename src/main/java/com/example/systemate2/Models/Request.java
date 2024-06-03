package com.example.systemate2.Models;

public class Request {
    private String request;
    private String type;
    private long salaryRequest;

    public String getRequestTitle() {
        return request;
    }
    public Long getRequestSalary() {
        return salaryRequest;
    }

    public String getTypeRequest(){
        return type;
    }

    public Request(String request) {
        this.request = request;
        type = "Title";
    }

    public Request(long salary) {
        this.salaryRequest = salary;
        type = "Salary";
    }
}
