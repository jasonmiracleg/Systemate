package com.example.systemate2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import com.example.systemate2.Models.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainApplication extends Application {
    private static int dayCount = 1;
    private static Stage mainStage;
    private static Admin currAdmin;
    private static Employee currEmployee;
    private static boolean changeDay = false;

    private static ArrayList<Integer> days = new ArrayList<>();
    private static boolean accounting = false;
    @Override
    public void start(Stage stage) throws IOException
    {
        mainStage = stage;
        currAdmin = new Admin("master", "oopKeren");
        currEmployee = new Employee("Yobel", "yobel123", "yobel123", "Employee");
        MainApplication.getCurrAdmin().addEmployee(currEmployee);
        changeScene("login", 600, 400);
        mainStage.show();
    }
    public static boolean getChangeDay()
    {
        return changeDay;
    }
    public static void setChangeDay(boolean newDay)
    {
        changeDay = newDay;
    }
    public static Admin getCurrAdmin()
    {
        return currAdmin;
    }
    public static void changeScene(String fxml, double width, double height) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("views/" + fxml + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        mainStage.setTitle("Systemate");
        mainStage.getIcons().add(new Image(MainApplication.class.getResourceAsStream("picture/icon-systemate.png")));
        mainStage.setScene(scene);
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);
        mainStage.setMaxHeight(400);
        mainStage.setMaxWidth(600);
    }

    public static void setDayCount(){
        dayCount++;
    }

    public static boolean isAccounting() {
        return accounting;
    }

    public static void main(String[] args)
    {
        launch();
    }


}