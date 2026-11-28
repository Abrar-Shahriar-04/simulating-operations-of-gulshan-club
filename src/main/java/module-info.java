module com.example.gulshanclubmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.gulshanclubmanagement to javafx.fxml;
    exports com.example.gulshanclubmanagement;
    opens com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757 to javafx.fxml, javafx.base;

}