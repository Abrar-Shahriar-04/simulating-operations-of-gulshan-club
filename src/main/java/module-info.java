module com.example.gulshanclubmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.gulshanclubmanagement to javafx.fxml;
    opens com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller to javafx.fxml;
    opens com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User to javafx.base;

    exports com.example.gulshanclubmanagement;
    exports com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.User;
    exports com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;
    exports com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

    opens com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller to javafx.fxml;
    opens com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User to javafx.base;
}