package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.VisitorPass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class VisitorPassController {

    @FXML
    private TextField visitorNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField hostMemberField;

    @FXML
    private TextField purposeField;

    @FXML
    private Label passIdLabel;

    @FXML
    private TableView<VisitorPass> visitorTable;

    @FXML
    private TableColumn<VisitorPass, String> colPassId;

    @FXML
    private TableColumn<VisitorPass, String> colName;

    @FXML
    private TableColumn<VisitorPass, String> colPhone;

    @FXML
    private TableColumn<VisitorPass, String> colHost;

    @FXML
    private TableColumn<VisitorPass, String> colPurpose;

    @FXML
    private TableColumn<VisitorPass, String> colStatus;

    private static final ObservableList<VisitorPass> visitorList = FXCollections.observableArrayList();
    private static int passCounter = 101;

    @FXML
    public void initialize() {
        colPassId.setCellValueFactory(new PropertyValueFactory<>("passId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("visitorName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colHost.setCellValueFactory(new PropertyValueFactory<>("hostMember"));
        colPurpose.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        visitorTable.setItems(visitorList);
    }

    public void generatePass(ActionEvent event) {
        String name = visitorNameField.getText();
        String phone = phoneField.getText();
        String host = hostMemberField.getText();
        String purpose = purposeField.getText();

        if (name.isEmpty() || phone.isEmpty()) {
            return;
        }

        String passId = "VP-" + passCounter;
        passCounter++;
        passIdLabel.setText("Pass ID: " + passId);

        VisitorPass pass = new VisitorPass(passId, name, phone, host, purpose, "Inside");
        visitorList.add(pass);

        visitorNameField.clear();
        phoneField.clear();
        hostMemberField.clear();
        purposeField.clear();
    }

    public void checkOutVisitor(ActionEvent event) {
        VisitorPass selected = visitorTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Checked Out");
            visitorTable.refresh();
        }
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Receptionist/receptionist_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}