package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import com.example.gulshanclubmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SecurityGuardDashboardController
{
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void LogLostAndFoundItemButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/LogLostandFoundItem.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void SignOutButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/login-view.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void CalculateParkingFeeButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/CalculateParkingFee.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void ReportSecurityIncidentButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/ReportSecurityIncident.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void RegisterContractorEntryButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/RegisterContractorEntry.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void LogVehicleEntryButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/LogVehicleEntry.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void LogCCTVCameraStatusButtonOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/LogCCTVCameraStatus.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void MarkLostItemAsClaimedButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/MarkLostItemAsClaimed.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void LogVehicleExitButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/LogVehicleExit.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}