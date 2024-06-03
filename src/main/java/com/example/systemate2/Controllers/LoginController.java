package com.example.systemate2.Controllers;

import com.example.systemate2.MainApplication;
import java.io.IOException;
public class LoginController {
    public void switchToEmployeeHome() throws IOException
    {
        MainApplication.changeScene("login-employee", 600, 400);
    }

    public void switchToAdminHome() throws IOException
    {
        MainApplication.changeScene("signup_login-admin", 600, 400);
    }
}