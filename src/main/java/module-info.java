module com.example.systemate2
{
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.systemate2 to javafx.fxml;
    exports com.example.systemate2;

    exports com.example.systemate2.Controllers;
    opens com.example.systemate2.Controllers to javafx.fxml;

    exports com.example.systemate2.Controllers.AdminFeature;
    opens com.example.systemate2.Controllers.EmployeeFeature to javafx.fxml;

    exports com.example.systemate2.Controllers.EmployeeFeature to javafx.fxml;
    opens com.example.systemate2.Controllers.AdminFeature to javafx.fxml;

    opens com.example.systemate2.Models to javafx.base;
}