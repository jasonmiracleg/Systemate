package com.example.systemate2.Controllers.AdminFeature;

import com.example.systemate2.MainApplication;
import com.example.systemate2.Models.CashFlow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CashFlowController{
    public TableColumn<CashFlow, LocalTime> cashflowColumnDate;
    public TableView<CashFlow> cashflowTable;
    public TableColumn<CashFlow, String> cashflowColumnIncome;
    public TableColumn<CashFlow, String> cashflowColumnOutcome;
    public TableColumn<CashFlow, String> cashflowColumnOnHand;
    public TextField outcomeInput;
    public TextField incomeInput;
    private static ObservableList<CashFlow> info = FXCollections.observableArrayList();

    public void back() throws IOException {
        MainApplication.changeScene("admin-feature", 600, 400);
    }

    public void addData(){
        String income = incomeInput.getText();
        String outcome = outcomeInput.getText();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        CashFlow cashFlow = new CashFlow(Long.parseLong(income), Long.parseLong(outcome), LocalTime.parse(currentTime.format(formatter)));
        info.add(cashFlow);
        cashflowTable.setItems(info);
        incomeInput.clear();
        outcomeInput.clear();
    }


    public void initialize() {
        cashflowColumnDate.setCellValueFactory(new PropertyValueFactory<>("timeProperty"));
        cashflowColumnIncome.setCellValueFactory(new PropertyValueFactory<>("income"));
        cashflowColumnOutcome.setCellValueFactory(new PropertyValueFactory<>("outcome"));
        cashflowColumnOnHand.setCellValueFactory(new PropertyValueFactory<>("cashOnHand"));

        cashflowTable.setItems(info);
    }
}
