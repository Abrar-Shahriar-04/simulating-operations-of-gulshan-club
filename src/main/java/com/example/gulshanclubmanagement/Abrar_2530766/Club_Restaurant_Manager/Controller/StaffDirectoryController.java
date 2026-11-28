package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.RestaurantEmployee;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StaffDirectoryController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<RestaurantEmployee> directoryTable;

    @FXML
    private TableColumn<RestaurantEmployee, String> colStaffId;

    @FXML
    private TableColumn<RestaurantEmployee, String> colFullName;

    @FXML
    private TableColumn<RestaurantEmployee, String> colPhone;

    @FXML
    private TableColumn<RestaurantEmployee, String> colRole;

    private final ObservableList<RestaurantEmployee> staffList = FXCollections.observableArrayList();
    private final String fileName = "employees.bin";

    @FXML
    public void initialize() {
        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        directoryTable.setItems(staffList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        staffList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<RestaurantEmployee> savedList = (ArrayList<RestaurantEmployee>) ois.readObject();
            staffList.addAll(savedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private void saveToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(new ArrayList<>(staffList));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    public void searchStaff(ActionEvent event) {
        String key = searchField.getText().trim().toLowerCase();
        if (key.isEmpty()) {
            directoryTable.setItems(staffList);
            return;
        }
        ObservableList<RestaurantEmployee> matched = FXCollections.observableArrayList();
        for (RestaurantEmployee emp : staffList) {
            boolean matchName = emp.getFullName() != null && emp.getFullName().toLowerCase().contains(key);
            boolean matchRole = emp.getRole() != null && emp.getRole().toLowerCase().contains(key);
            if (matchName || matchRole) {
                matched.add(emp);
            }
        }
        directoryTable.setItems(matched);
    }

    public void showAllStaff(ActionEvent event) {
        directoryTable.setItems(staffList);
    }

    public void removeStaff(ActionEvent event) {
        RestaurantEmployee selected = directoryTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            staffList.remove(selected);
            saveToFile();
            directoryTable.setItems(staffList);
        }
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Restaurant_Manager/restaurant_manager_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}