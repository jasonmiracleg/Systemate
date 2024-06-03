package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminHome
{
    public void employeeRegistration() throws IOException
    {
        MainApplication.changeScene("employeeRegistration-admin", 600, 400);
    }
    public void companyCashflow() throws IOException
    {
        MainApplication.changeScene("cashFlow-admin", 600, 400);
    }
    public void salaryArrangement() throws IOException
    {
        MainApplication.changeScene("salaryArrangement-admin", 600,400);
    }
    public void employeeRequest() throws IOException
    {
        MainApplication.changeScene("approvalRequest-admin", 600, 400);
    }
    public void exitScene() throws IOException
    {

        MainApplication.changeScene("login", 600,400);
    }
}
