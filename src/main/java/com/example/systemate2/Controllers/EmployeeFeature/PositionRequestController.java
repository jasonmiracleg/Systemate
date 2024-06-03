package com.example.systemate2.Controllers.EmployeeFeature;

import com.example.systemate2.MainApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
public class PositionRequestController
{
    private static int employeeIndex;
    private String positionRequest;
    public RadioButton itManagerScenario;
    public RadioButton marketingManagerScenario;
    public RadioButton hrManagerScenario;
    public RadioButton financeManagerScenario;
    public RadioButton operationalManagerScenario;

    private ToggleGroup title;
    public static void setIndex(int index)
    {
        employeeIndex = index;
    }
    public void positionRequest() throws IOException
    {
        RadioButton choice = (RadioButton) title.getSelectedToggle();
        if (MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).getRequest() != null)
        {
            this.notificationForFirstCondition();
            MainApplication.changeScene("employee-feature", 600, 400);
        } else if (choice == null){
            warning();
        }
        else
        {
            this.notNullCondition();
        }
    }

    public void initialize() {
        title = new ToggleGroup();
        itManagerScenario.setToggleGroup(title);
        marketingManagerScenario.setToggleGroup(title);
        hrManagerScenario.setToggleGroup(title);
        financeManagerScenario.setToggleGroup(title);
        operationalManagerScenario.setToggleGroup(title);
    }

    private void notNullCondition() throws IOException
    {
        if (itManagerScenario.isSelected())
        {
            this.positionRequest = "IT Manager";
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestTitle("IT Manager");
        }
        else if (marketingManagerScenario.isSelected())
        {
            this.positionRequest = "Marketing Manager";
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestTitle("Marketing Manager");
        }
        else if (hrManagerScenario.isSelected())
        {
            this.positionRequest = "Human Resource Manager";
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestTitle("Human Resource Manager");
        }
        else if (financeManagerScenario.isSelected())
        {
            this.positionRequest = "Finance Manager";
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestTitle("Finance Manager");
        }
        else if (operationalManagerScenario.isSelected())
        {
            this.positionRequest = "Operational Manager";
            MainApplication.getCurrAdmin().getEmployees().get(employeeIndex).requestTitle("Operational Manager");
        }
        this.notificationForSecondCondition();
        MainApplication.changeScene("employee-feature", 600, 400);
    }
    private void notificationForFirstCondition()
    {
        Alert notify = new Alert(Alert.AlertType.WARNING);
        notify.setTitle("ACTION UNSUCCESSFUL!");
        notify.setHeaderText("FAILED TO SUBMIT!!");
        notify.setContentText("Request can only be submitted once! ");
        notify.show();
    }
    private void notificationForSecondCondition()
    {
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.setTitle("ACTION SUCCESSFUL!");
        notify.setHeaderText("Your action has been recorded!");
        notify.setContentText("Your request has been successfully submitted! ");
        notify.show();
    }

    private void warning(){
        Alert warn = new Alert(Alert.AlertType.WARNING);
        warn.setTitle("ACTION UNSUCCESSFUL!");
        warn.setHeaderText("FAILED TO SUBMIT");
        warn.setContentText("Please select one of the option!");
        warn.notify();
    }

    public void back() throws IOException {
        MainApplication.changeScene("employee-feature", 600, 400);
    }
}
