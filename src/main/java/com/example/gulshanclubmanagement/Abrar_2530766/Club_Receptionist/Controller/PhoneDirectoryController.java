package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.DepartmentContact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PhoneDirectoryController {

    @FXML
    private TextField searchDeptField;

    @FXML
    private TableView<DepartmentContact> directoryTable;

    @FXML
    private TableColumn<DepartmentContact, String> colDepartment;

    @FXML
    private TableColumn<DepartmentContact, String> colExtension;

    @FXML
    private TableColumn<DepartmentContact, String> colHotline;

    private final ObservableList<DepartmentContact> deptList = FXCollections.observableArrayList(
            new DepartmentContact("Security", "101", "999"),
            new DepartmentContact("Maintenance", "102", "1020"),
            new DepartmentContact("Front Desk", "100", "1000"),
            new DepartmentContact("Kitchen", "105", "1050"),
            new DepartmentContact("Billing", "108", "1080")
    );

    @FXML
    public void initialize() {
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        colExtension.setCellValueFactory(new PropertyValueFactory<>("extensionNumber"));
        colHotline.setCellValueFactory(new PropertyValueFactory<>("emergencyHotline"));
        directoryTable.setItems(deptList);
    }

    public void searchDepartment(ActionEvent event) {
        String key = searchDeptField.getText().trim().toLowerCase();
        if (key.isEmpty()) {
            directoryTable.setItems(deptList);
            return;
        }
        ObservableList<DepartmentContact> matched = FXCollections.observableArrayList();
        for (DepartmentContact d : deptList) {
            if (d.getDepartmentName().toLowerCase().contains(key)) {
                matched.add(d);
            }
        }
        directoryTable.setItems(matched);
    }

    public void showAllDepartments(ActionEvent event) {
        directoryTable.setItems(deptList);
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