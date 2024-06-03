package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Label;

import java.io.IOException;

public class SalaryExpectationController
{
    private static int employeeIndex;

    public Label salaryInfo;
    public Label employeeTitle;

    public static void setIndex(int index)
    {
        employeeIndex = index;
    }
    public void checkSalary(){
        if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getEmployeeAttendance().size() != 0) {
            if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getCurrAttendance() == 1) {
                if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getSalary() == 0L
                ){
                    salaryInfo.setText("Sorry, the salary has not been set");
                } else {
                    salaryInfo.setText("Rp " + MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getSalary());
                }
            } else {
                salaryInfo.setText("You are not present today");
            }
        } else {
            salaryInfo.setText("You are not present today");
        }
    }

    public void back() throws IOException {
        MainApplication.changeScene("employee-feature", 600, 400);
    }

    public void initialize() {
        employeeTitle.setText(MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getTitle());
    }
}
