package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import com.example.systemate2.Models.Employee;
import com.example.systemate2.Models.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ApprovalRequestController {

    public TableView<Employee> employeeRequest;
    public TableColumn<Employee, String> employeeCol;
    public TableColumn<Employee, String> requestCol;
    public Label employeeName;
    private Employee pickEmployee;
    private List<Employee> temp = FXCollections.observableArrayList();
    ObservableList<Employee> employeeList = FXCollections.observableArrayList();


    public void initialize() {
        employeeCol.setCellValueFactory(new PropertyValueFactory("name"));
        // This Lambda expression will work as long as you have made the getter of the property - MILESTONE
        requestCol.setCellValueFactory(data -> data.getValue().getRequestProperty());

        fetchRequestData(MainApplication.getCurrAdmin().getEmployees());

        employeeRequest.getSelectionModel().selectedItemProperty().addListener((observe, lastChoice, newChoice) -> {
            if (newChoice != null) {
                pickEmployee = newChoice;
                employeeName.setText(pickEmployee.getName());
            } else {
                employeeName.setText("");
                pickEmployee = null;
            }
        });
    }

    private void fetchRequestData(List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getRequest() != null) {
                temp.add(employee);
            }
        }
        employeeList = FXCollections.observableArrayList(temp);
        employeeRequest.setItems(employeeList);
    }

    public void back() throws IOException {
        MainApplication.changeScene("admin-feature", 600, 400);
    }

    public void approveRequest() {
        if (pickEmployee != null) {
            if (pickEmployee.getRequest().getTypeRequest().equalsIgnoreCase("title")) {
                pickEmployee.setTitle(pickEmployee.getRequest().getRequestTitle());
                HashMap<String, Long> temp = MainApplication.getCurrAdmin().getSalaryList();
                for (Map.Entry<String, Long> check : temp.entrySet()) {
                    if (pickEmployee.getTitle().equals(check.getKey())) {
                        pickEmployee.setSalary(check.getValue());
                        break;
                    }
                }
            } else if (pickEmployee.getRequest().getTypeRequest().equalsIgnoreCase("salary")) {
                pickEmployee.raiseSalary(pickEmployee.getRequest().getRequestSalary());
            }
            pickEmployee.updateRequest();
            employeeList.remove(pickEmployee);
            employeeRequest.refresh();
            approveNotif();
        } else {
            errorNotif();
        }
    }

    public void rejectRequest() {
        if (pickEmployee != null) {
            pickEmployee.updateRequest();
            employeeList.remove(pickEmployee);
            employeeRequest.refresh();
            declineNotif();
        } else {
            notify();
        }
    }

    public void approveNotif(){
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.setTitle("APPROVED REQUEST!");
        notify.setHeaderText("REQUEST PROCEEDED SUCCESSFULLY!!");
        notify.setContentText("You have approved your employee request");
        notify.showAndWait();
    }

    public void declineNotif(){
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.setTitle("REJECTED REQUEST!");
        notify.setHeaderText("REQUEST PROCEEDED SUCCESSFULLY!!");
        notify.setContentText("You have rejected your employee request");
        notify.showAndWait();
    }

    public void errorNotif(){
        Alert notify = new Alert(Alert.AlertType.WARNING);
        notify.setTitle("ERROR REQUEST!");
        notify.setHeaderText("REQUEST CAN'T BE PROCEEDED!!");
        notify.setContentText("There's no request selected");
        notify.showAndWait();
    }
}
