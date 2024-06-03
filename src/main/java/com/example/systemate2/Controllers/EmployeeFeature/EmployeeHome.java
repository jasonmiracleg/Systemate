package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;

import java.io.IOException;

public class EmployeeHome
{
    private static int employeeIndex;
    public static void setIndex(int index)
    {
        employeeIndex = index;
    }
    public void attendanceButton() throws IOException
    {
        MainApplication.changeScene("attendance-employee", 600, 400);
    }
    public void exitButton() throws IOException
    {
        MainApplication.setChangeDay(false);
        MainApplication.changeScene("login", 600, 400);
    }
    public void bonusRequestButton() throws IOException
    {
        MainApplication.changeScene("bonusRequest-employee", 600, 400);
    }
    public void positionRequestButton() throws IOException
    {
        if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getTitle().equalsIgnoreCase("Employee")) {
            MainApplication.changeScene("positionRequest-employee", 600, 400);
        } else {
            notification();
        }
    }
    public void salaryExpectationButton() throws IOException
    {
        MainApplication.changeScene("salaryExpectation-employee", 600, 400);
    }

    private void notification(){
        Alert notification = new Alert(Alert.AlertType.WARNING);
        notification.setTitle("ACCESS DENIED!");
        notification.setHeaderText("REQUEST NOT PERMITTED");
        notification.setContentText("You have reached the highest title!");
        notification.showAndWait();
    }


}
