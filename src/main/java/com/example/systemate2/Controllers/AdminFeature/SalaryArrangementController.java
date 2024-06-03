package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import com.example.systemate2.Models.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class SalaryArrangementController {
    @FXML
    public RadioButton itManager;
    @FXML
    public RadioButton marketingManager;
    @FXML
    public RadioButton hrManager;
    @FXML
    public RadioButton financeManager;
    @FXML
    public RadioButton operationalManager;
    @FXML
    public RadioButton employee;
    @FXML
    public RadioButton enableT;
    @FXML
    public RadioButton disableT;
    @FXML
    public TextField salaryInput;

    ToggleGroup titles;
    private String title;

    @FXML
    public void initialize() {
        titles = new ToggleGroup();
        itManager.setToggleGroup(titles);
        marketingManager.setToggleGroup(titles);
        hrManager.setToggleGroup(titles);
        financeManager.setToggleGroup(titles);
        operationalManager.setToggleGroup(titles);
        employee.setToggleGroup(titles);

        ToggleGroup tax = new ToggleGroup();
        enableT.setToggleGroup(tax);
        disableT.setToggleGroup(tax);
    }

    public void finalizeSalary() throws IOException {
        if (salaryInput.getText().isBlank() && titles.getSelectedToggle() == null) {
            unsuccessfully();
        } else if (!enableT.isSelected() && !disableT.isSelected()) {
            unsuccessfully();
        } else {
            String input = salaryInput.getText();
            if (input.matches("\\d+")) {
                Long salary = Long.parseLong(salaryInput.getText());
                if (enableT.isSelected()) {
                    salary = pajak(salary);
                    settingTitleSalary(salary);
                } else if (disableT.isSelected()) {
                    settingTitleSalary(salary);
                }
                HashMap<String, Long> temp = MainApplication.getCurrAdmin().getSalaryList();
                for (Employee currEmployee : MainApplication.getCurrAdmin().getEmployees()) {
                    for (Map.Entry<String, Long> check : temp.entrySet()) {
                        if (currEmployee.getTitle().equals(check.getKey())) {
                            currEmployee.setSalary(check.getValue());
                            break;
                        }
                    }
                }
                MainApplication.changeScene("admin-feature", 600, 400);
            } else {
                invalidInput();
            }
        }
    }

    public Long pajak(Long salary) {
        Long pkp;
        Long temp;
        Long pajak1 = 166700L;
        Long pajak2 = 694000L;
        Long pajak3 = 1388900L;
        Long pajak4 = 13889000L;

        pkp = salary - 150000;
        if (pkp > 0) {
            if (pkp < pajak1) {
                salary = salary - (pkp * 5) / 100;
            } else if (pkp >= pajak1 && pkp < pajak2) {
                temp = pkp - pajak1;
                salary = salary - (((pajak1 * 5) / 100) + ((temp * 15) / 100));
            } else if (pkp >= pajak2 && pkp < pajak3) {
                temp = pkp - (pajak1 + pajak2);
                salary = salary - (((pajak1 * 5) / 100) + ((pajak2 * 15) / 100) + ((temp * 25) / 100));
            } else if (pkp >= pajak3 && pkp < pajak4) {
                temp = pkp - (pajak1 + pajak2 + pajak3);
                salary = salary - (((pajak1 * 5) / 100) + ((pajak2 * 15) / 100) + ((pajak3 * 25) / 100) + ((temp * 30) / 100));
            } else if (pkp >= pajak4) {
                temp = pkp - (pajak1 + pajak2 + pajak3 + pajak4);
                salary = salary - (((pajak1 * 5) / 100) + ((pajak2 * 15) / 100) + ((pajak3 * 25) / 100) + ((pajak4 * 30) / 100) + ((temp * 35) / 100));
            }
        }
        return salary;
    }

    private void settingTitleSalary(Long salary) {
        HashMap<String, Long> temp = MainApplication.getCurrAdmin().getSalaryList();
        if (itManager.isSelected()) {
            if (temp.containsKey("IT Manager")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("IT Manager")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "IT Manager";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        } else if (marketingManager.isSelected()) {
            if (temp.containsKey("Marketing Manager")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("Marketing Manager")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "Marketing Manager";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        } else if (hrManager.isSelected()) {
            if (temp.containsKey("Human Resource Manager")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("Human Resource Manager")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "Human Resource Manager";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        } else if (operationalManager.isSelected()) {
            if (temp.containsKey("Operational Manager")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("Operational Manager")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "Operational Manager";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        } else if (financeManager.isSelected()) {
            if (temp.containsKey("Finance Manager")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("Finance Manager")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "Finance Manager";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        } else if (employee.isSelected()) {
            if (temp.containsKey("Employee")) {
                for (Map.Entry<String, Long> entry : temp.entrySet()) {
                    if (entry.getKey().equals("Employee")) {
                        title = entry.getKey();
                        break;
                    }
                }
                updateSalary(title);
            } else {
                title = "Employee";
                setFirstSalary(title);
            }
            MainApplication.getCurrAdmin().updateSalary(title, salary);
        }
    }

    private void updateSalary(String title) {
        Alert notification = new Alert(Alert.AlertType.INFORMATION);
        notification.setTitle("SALARY SUCCESSFULLY UPDATED");
        notification.setHeaderText("Successfully Updated Salary");
        notification.setContentText("You have successfully updated " + title + "'s salary!");
        notification.show();
    }

    private void setFirstSalary(String title) {
        Alert notification = new Alert(Alert.AlertType.INFORMATION);
        notification.setTitle("SALARY SUCCESSFULLY SET");
        notification.setHeaderText("Successfully Set Salary");
        notification.setContentText("You have successfully set " + title + "'s salary!");
        notification.show();
    }

    private void unsuccessfully() {
        Alert unsuccessful = new Alert(Alert.AlertType.ERROR);
        unsuccessful.setTitle("UNSUCCESSFULLY SET");
        unsuccessful.setHeaderText("Unsuccessfully Set Salary");
        unsuccessful.setContentText("Please select the options");
        unsuccessful.show();
    }

    private void invalidInput(){
        Alert unsuccessful = new Alert(Alert.AlertType.ERROR);
        unsuccessful.setTitle("UNSUCCESSFULLY SET");
        unsuccessful.setHeaderText("Unsuccessfully Set Salary");
        unsuccessful.setContentText("The salary can only be filled with numeric");
        unsuccessful.show();
    }
}
