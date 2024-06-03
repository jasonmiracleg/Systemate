package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EmployeeLogin
{
    public TextField usernameInput;
    public TextField passwordInput;
    public void employeeLoginScene() throws IOException
    {
        if (MainApplication.getCurrAdmin().getEmployees().isEmpty())
        {
            this.firstCase();
        }
        else
        {
            this.secondCase();
        }
    }
    private void firstCase() throws IOException
    {
        Alert nullPointer = new Alert(Alert.AlertType.ERROR);
        nullPointer.setTitle("LOGIN ERROR! ");
        nullPointer.setHeaderText("Login FAILED");
        nullPointer.setContentText("This company doesn't have any employee!");
        MainApplication.changeScene("login", 600, 400);
        nullPointer.show();
    }
    private void secondCase() throws IOException
    {
        boolean isThere = false;
        for (int i = 0; i < MainApplication.getCurrAdmin().getEmployees().size(); i++)
        {
            if (usernameInput.getText().equals(MainApplication.getCurrAdmin().getEmployees().get(i).getUsername()) && passwordInput.getText().equals(MainApplication.getCurrAdmin().getEmployees().get(i).getPassword()))
            {
                isThere = true;
                EmployeeHome.setIndex(i);
                AttendaceController.setIndex(i);
                BonusRequestController.setIndex(i);
                PositionRequestController.setIndex(i);
                SalaryExpectationController.setIndex(i);
                MainApplication.changeScene("employee-feature", 600, 400);
                break;
            }
        }
        if (!isThere)
        {
            Alert notFound = new Alert(Alert.AlertType.ERROR);
            notFound.setTitle("LOGIN ERROR! ");
            notFound.setHeaderText("Login FAILED");
            notFound.setContentText("Input the correct username or password!!");
            notFound.showAndWait();
        }
    }

    public void back() throws IOException {
        MainApplication.changeScene("login", 600, 400);
    }
}
