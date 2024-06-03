package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;

import java.io.IOException;

public class AttendaceController
{
    private static int employeeIndex;
    public static void setIndex(int index)
    {
        employeeIndex = index;
    }
    public void attendToday() throws IOException
    {
        if (!MainApplication.getChangeDay())
        {
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).setAttendance(1);
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).setCurrAttendance(1);
            Alert attendanceNotify = new Alert(Alert.AlertType.INFORMATION);
            attendanceNotify.setTitle("ACTION SUCCESSFUL!");
            attendanceNotify.setHeaderText("Your action has been recorded!");
            attendanceNotify.setContentText("Thank you for attend today");
            attendanceNotify.show();
            MainApplication.setChangeDay(true);
            MainApplication.changeScene("employee-feature", 600, 400);
        }
        else
        {
            Alert attendanceNotify = new Alert(Alert.AlertType.ERROR);
            attendanceNotify.setTitle("ACTION UNSUCCESSFUL!");
            attendanceNotify.setHeaderText("Attendance can only be filled once a day!");
            attendanceNotify.setContentText("You have filled this absence today! ");
            attendanceNotify.show();
            MainApplication.changeScene("employee-feature", 600, 400);
        }
    }

    public void absentToday() throws IOException
    {
        if (!MainApplication.getChangeDay())
        {
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).setAttendance(0);
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).setCurrAttendance(0);
            Alert attendanceNotify = new Alert(Alert.AlertType.WARNING);
            attendanceNotify.setTitle("ACTION SUCCESSFUL!");
            attendanceNotify.setHeaderText("Your action has been recorded!");
            attendanceNotify.setContentText("As a reminder, please don't be absent too often");
            attendanceNotify.show();
            MainApplication.setChangeDay(true);
            MainApplication.changeScene("employee-feature", 600, 400);
        }
        else
        {
            Alert attendanceNotify = new Alert(Alert.AlertType.ERROR);
            attendanceNotify.setTitle("ACTION UNSUCCESSFUL!");
            attendanceNotify.setHeaderText("Attendance can only be filled once a day!");
            attendanceNotify.setContentText("You have filled this absence today! ");
            attendanceNotify.show();
            MainApplication.changeScene("employee-feature", 600, 400);
        }
    }
}
