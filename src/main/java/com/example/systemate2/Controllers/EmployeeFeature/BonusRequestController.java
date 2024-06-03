package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BonusRequestController
{
    public TextField bonusInput;
    private static int employeeIndex;
    public static void setIndex(int index)
    {
        employeeIndex = index;
    }
    public void requestBonus() throws IOException
    {
        if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getRequest() == null)
        {
            try
            {
                long bonusRequest = Long.parseLong(bonusInput.getText());
                MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestSalary(bonusRequest);

                Alert notify = new Alert(Alert.AlertType.INFORMATION);
                notify.setTitle("ACTION SUCCESSFUL!");
                notify.setHeaderText("Your action has been recorded!");
                notify.setContentText("Your request has been successfully submitted! ");
                notify.show();
                MainApplication.changeScene("employee-feature", 600, 400);
            }
            catch (NumberFormatException e)
            {
                Alert notify = new Alert(Alert.AlertType.WARNING);
                notify.setTitle("ACTION UNSUCCESSFUL!");
                notify.setHeaderText("FAILED TO SUBMIT!!");
                notify.setContentText("Bonus must be filled in as a numeric value! ");
                notify.showAndWait();
            }
        }
        else
        {
            Alert notify = new Alert(Alert.AlertType.WARNING);
            notify.setTitle("ACTION UNSUCCESSFUL!");
            notify.setHeaderText("FAILED TO SUBMIT!!");
            notify.setContentText("Request can only be submitted once! ");
            notify.show();
            MainApplication.changeScene("employee-feature", 600, 400);
        }
    }

    public void back() throws IOException {
        MainApplication.changeScene("employee-feature", 600, 400);
    }
}
