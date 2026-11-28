package com.example.gulshanclubmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome to Gulshan Club");
        stage.setScene(scene);
        stage.show();
    }
}
