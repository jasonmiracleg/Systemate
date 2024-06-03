package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpLoginAdmin
{
    public TextField usernameInput;
    public TextField passwordInput;

    public void loginAdmin() throws IOException
    {
        if(MainApplication.getCurrAdmin().getUsername().equals(usernameInput.getText()) && MainApplication.getCurrAdmin().getPassword().equals(passwordInput.getText()))
        {
            MainApplication.changeScene("admin-feature", 600, 400);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("LOGIN ERROR!");
            alert.setHeaderText("Login FAILED");
            alert.setContentText("Input the correct username or password!!");
            alert.showAndWait();
        }
    }

    public void back() throws IOException {
        MainApplication.changeScene("login", 600, 400);
    }
}
