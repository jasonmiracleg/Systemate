package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import com.example.systemate2.Models.Employee;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRegistrationController
{
    public TextField usernameInput;
    public TextField passwordInput;
    public TextField nameInput;
    private static Employee newEmployee;
    public RadioButton employee;
    public RadioButton hrManager;
    public RadioButton operationalManager;
    public RadioButton marketingManager;
    public RadioButton itManager;
    public RadioButton financeManager;
    public  ToggleGroup title;

    public void initialize() {
        title = new ToggleGroup();
        itManager.setToggleGroup(title);
        marketingManager.setToggleGroup(title);
        hrManager.setToggleGroup(title);
        financeManager.setToggleGroup(title);
        operationalManager.setToggleGroup(title);
        employee.setToggleGroup(title);
    }

        public void employeeRegistScene() throws IOException
    {
        if (usernameInput.getLength() != 8 || passwordInput.getLength() != 8)
        {
            this.firstCase();
        }
        else if (this.checkTwinUsername())
        {
            this.secondCase();
        }
        else if (!itManager.isSelected() && !marketingManager.isSelected() && !hrManager.isSelected() && !financeManager.isSelected() && !operationalManager.isSelected() && !employee.isSelected()){
            this.fourthCase();
        }
        else
        {
            this.thirdCase();
        }
    }
    private void firstCase()
    {
        Alert inputAlert = new Alert(Alert.AlertType.ERROR);
        inputAlert.setTitle("REGISTER ERROR!");
        inputAlert.setHeaderText("Register FAILED");
        inputAlert.setContentText("Username and password must contains only 8 character! ");
        inputAlert.showAndWait();
    }
    private boolean checkTwinUsername()
    {
        boolean toReturn = false;
        for (int i = 0; i < MainApplication.getCurrAdmin().getEmployees().size(); i++)
        {
            if (MainApplication.getCurrAdmin().getEmployees().get(i).getUsername().equals(this.usernameInput.getText()))
            {
                toReturn = true;
            }
        }
        return toReturn;
    }
    private void secondCase()
    {
        Alert inputAlert = new Alert(Alert.AlertType.ERROR);
        inputAlert.setTitle("REGISTER ERROR!");
        inputAlert.setHeaderText("Register FAILED");
        inputAlert.setContentText("Username is already registered! ");
        inputAlert.showAndWait();
    }
    private void thirdCase() throws IOException
    {
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.setTitle("REGISTER SUCCESSFUL !");
        notify.setHeaderText("Successfully added new employee");
        notify.setContentText("You have successfully registered " + nameInput.getText() + "!");
        notify.show();
        RadioButton choice = (RadioButton) title.getSelectedToggle();
        newEmployee = new Employee(nameInput.getText(), usernameInput.getText(), passwordInput.getText(), choice.getText() );
        MainApplication.getCurrAdmin().addEmployee(newEmployee);
        HashMap<String, Long> temp = MainApplication.getCurrAdmin().getSalaryList();
        for (Map.Entry<String, Long> check : temp.entrySet()){
            if (newEmployee.getTitle().equals(check.getKey())){
                newEmployee.setSalary(check.getValue());
                break;
            }
        }
        MainApplication.changeScene("admin-feature", 600, 400);
    }

    private void fourthCase() throws IOException {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("INVALID TITLE");
        error.setHeaderText("Register FAILED");
        error.setContentText("Please select one of the title");
        error.show();
    }

    public void back() throws IOException {
        MainApplication.changeScene("admin-feature", 600, 400);
    }
}
