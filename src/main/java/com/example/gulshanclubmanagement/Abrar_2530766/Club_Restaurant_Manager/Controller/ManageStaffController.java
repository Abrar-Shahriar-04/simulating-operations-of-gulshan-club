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
import javafx.scene.control.ComboBox;
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

public class ManageStaffController {

    @FXML
    private TextField staffIdField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TableView<RestaurantEmployee> employeeTable;

    @FXML
    private TableColumn<RestaurantEmployee, String> colStaffId;

    @FXML
    private TableColumn<RestaurantEmployee, String> colFullName;

    @FXML
    private TableColumn<RestaurantEmployee, String> colPhone;

    @FXML
    private TableColumn<RestaurantEmployee, String> colRole;

    private final ObservableList<RestaurantEmployee> employeeList = FXCollections.observableArrayList();
    private final String fileName = "employees.bin";

    @FXML
    public void initialize() {
        roleComboBox.setItems(FXCollections.observableArrayList("Chef", "Waiter", "Cleaner", "Cashier"));
        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        employeeTable.setItems(employeeList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        employeeList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<RestaurantEmployee> savedList = (ArrayList<RestaurantEmployee>) ois.readObject();
            employeeList.addAll(savedList);
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
            oos.writeObject(new ArrayList<>(employeeList));
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

    public void addEmployee(ActionEvent event) {
        String id = staffIdField.getText();
        String name = fullNameField.getText();
        String phone = phoneField.getText();
        String role = roleComboBox.getValue();

        if (id.isEmpty() || name.isEmpty() || role == null) {
            return;
        }

        RestaurantEmployee emp = new RestaurantEmployee(id, name, phone, role);
        employeeList.add(emp);
        saveToFile();

        staffIdField.clear();
        fullNameField.clear();
        phoneField.clear();
        roleComboBox.setValue(null);
    }

    public void deleteEmployee(ActionEvent event) {
        RestaurantEmployee selected = employeeTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            employeeList.remove(selected);
            saveToFile();
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